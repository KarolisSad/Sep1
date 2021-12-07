package mediator;

import model.Class;
import model.*;

public class ScheduleModelManager
{
  private RoomList roomList;
  private SessionList sessionList;
  private CourseList courseList;
  private TeacherList teacherList;
  private StudentList studentList;
  private ClassList classList;

  public ScheduleModelManager()
  {
    this.roomList = new RoomList();
    this.sessionList = new SessionList();
    this.courseList = new CourseList();
    this.teacherList = new TeacherList();
    this.studentList = new StudentList();
    this.classList = new ClassList();
  }

  public void addRoom(int capacity, String roomNumber)
  {
    for (int i = 0; i < roomList.getNumberOfRooms(); i++)
    {
      if (roomList.getRoom(i).getRoomNumber().equals(roomNumber))
      {
        throw new IllegalArgumentException(
            "Room with same name already added: " + roomList.getRoom(i));
      }
    }

    roomList.addRoom(new Room(capacity, roomNumber));
  }

  public Class getClassByID(String className)
  {
    for (int i = 0; i < classList.size(); i++)
    {
      if (classList.getClassByIndex(i).getClassName().equals(className))
      {
        return classList.getClassByIndex(i);
      }
    }
    throw new IllegalArgumentException(
        "Could not find class with name: " + className);
  }

  public Teacher getTeacherByID(String teacherID)
  {
    for (int i = 0; i < teacherList.size(); i++)
    {
      if (teacherList.getTeacher(i).getTeacherId().equals(teacherID))
      {
        return teacherList.getTeacher(i);
      }
    }
    throw new IllegalArgumentException(
        "Could not find teacher with ID: " + teacherID);
  }

  public Student getStudentByID(String studentID)
  {
    for (int i = 0; i < studentList.size(); i++)
    {
      if (studentList.getStudent(i).getStudentId().equals(studentID))
      {
        return studentList.getStudent(i);
      }
    }
    throw new IllegalArgumentException(
        "Could not find student with ID: " + studentID);
  }

  public void addCourse(String name, int ECTS, String mainClass,
      String firstTeacherID)
  {
    model.Class classToAdd = getClassByID(mainClass);
    Teacher teacherToAdd = getTeacherByID(firstTeacherID);

    for (int i = 0; i < courseList.getNumberOfCourses(); i++)
    {
      if (courseList.getCourse(i).getCourseName()
          .equals(name + classToAdd.getClassID()))
      {
        throw new IllegalArgumentException(
            "Course with same name already added.");
      }
    }
    courseList.addCourse(new Course(name, ECTS, classToAdd, teacherToAdd));

  }

  public void addTeacher(String name, String teacherID)
  {
    for (int i = 0; i < teacherList.size(); i++)
    {
      if (teacherList.getTeacher(i).getTeacherId().equals(teacherID))
      {
        throw new IllegalArgumentException(
            "Teacher with same ID already added: " + teacherList.getTeacher(i));
      }
    }

    teacherList.addTeacher(new Teacher(name, new TeacherID(teacherID)));
  }

  public void addStudent(String name, int studentID, String classID,
      int semester)
  {
    for (int i = 0; i < studentList.size(); i++)
    {
      if (studentList.getStudent(i).getStudentId().equals("" + studentID))
      {
        throw new IllegalArgumentException(
            "Student with same ID already added: " + studentList.getStudent(i));
      }
    }
    studentList.addStudent(
        new Student(name, new StudentID(studentID), classID, semester));
  }

  public void addSession(String courseName, int sessionLength, int dateDay,
      int dateMonth, int dateYear, int timeHour, int timeMinute,
      String roomNumber)
  {
    DateTime sessionStartTime = new DateTime(
        new Date(dateDay, dateMonth, dateYear), new Time(timeHour, timeMinute));
    DateTime sessionEndTime = new DateTime(
        new Date(dateDay, dateMonth, dateYear),
        new Time(timeHour + sessionLength, timeMinute));

    if (isRoomAvailable(roomList.getRoomByRoomNumber(roomNumber),
        sessionStartTime, sessionEndTime) && isMainClassStudentsAvailable(
        courseList.getCourseByName(courseName).getMainClass(), sessionStartTime,
        sessionEndTime) && isOtherCourseStudentsAvailable(
        courseList.getCourseByName(courseName), sessionStartTime,
        sessionEndTime) && isTeacherAvailable(
        courseList.getCourseByName(courseName), sessionStartTime,
        sessionEndTime))
    {
      sessionList.addSession(
          new Session(courseList.getCourseByName(courseName), sessionLength,
              sessionStartTime, roomList.getRoomByRoomNumber(roomNumber)));
    }

    else
      throw new IllegalArgumentException("Session not created");
  }

  public boolean isRoomAvailable(Room room, DateTime startTime,
      DateTime endTime)
  {
    for (int i = 0; i < sessionList.getNumberOfSessions(); i++)
    {
      if (sessionList.getSession(i).getRoom().getRoomNumber()
          .equals(room.getRoomNumber()) && sessionList.getSession(i)
          .getStartDateTime()
          .getDate() // if room is the same AND date is the same
          .equals(startTime.getDate()))
      {
        if (startTime.getTime()
            .isBefore(sessionList.getSession(i).getEndDateTime().getTime())
            // if starttime of new session is before endTime of any session is list
            && !(endTime.getTime()
            .isBefore(sessionList.getSession(i).getStartDateTime().getTime())))
        //if endtime is NOT before starttime of any session in list
        {
          return false;
          /*
          throw new IllegalArgumentException(
              "Room already in use for selected time. Room used by: "
                  + sessionList.getSession(i));

           */
        }
      }
    }
    return true;
  }

  public boolean isMainClassStudentsAvailable(model.Class mainClass,
      DateTime startTime, DateTime endTime)
  {
    for (int i = 0; i < sessionList.getNumberOfSessions(); i++)
    {
      if (sessionList.getSession(i).getCourse().getMainClass().equals(mainClass)
          && sessionList.getSession(i).getStartDateTime().getDate()
          .equals(startTime.getDate()))
      {
        if (startTime.getTime()
            .isBefore(sessionList.getSession(i).getEndDateTime().getTime())
            && !(endTime.getTime()
            .isBefore(sessionList.getSession(i).getStartDateTime().getTime())))
        {
          throw new IllegalArgumentException(
              "Main Class students not available for sessions. Cause: "
                  + sessionList.getSession(i));
        }
      }
    }
    return true;
  }

  public boolean isTeacherAvailable(Course course, DateTime startTime,
      DateTime endTime)
  {
    for (int i = 0; i < course.getCourseTeacherList().size(); i++)
    {
      for (int j = 0; j < sessionList.getNumberOfSessions(); j++)
        if (sessionList.getSession(j).getCourse().getCourseTeacherList()
            .contains(course.getCourseTeacherList().getTeacher(i))
            && startTime.getDate()
            .equals(sessionList.getSession(j).getStartDateTime().getDate()))
        {
          if (startTime.getTime()
              .isBefore(sessionList.getSession(j).getEndDateTime().getTime())
              && !(endTime.getTime().isBefore(
              sessionList.getSession(j).getStartDateTime().getTime())))
          {
            throw new IllegalArgumentException(
                "Teacher " + course.getCourseTeacherList().getTeacher(i)
                    + " not available due to: " + sessionList.getSession(j));
          }
        }
    }
    return true;
  }

  public boolean isOtherCourseStudentsAvailable(Course course,
      DateTime startTime, DateTime endTime)
  {
    StudentList studentsNotInMainClass = new StudentList();
    if (course.getCourseStudentList()
        .equals(course.getMainClass().getClassStudentList()))
    {
      return true;
    }
    else
    {
      for (int i = 0; i < course.getCourseSize(); i++)
      {
        for (int j = 0; j < course.getMainClass().getNumberOfStudents(); j++)
        {
          if (!(course.getCourseStudentList().getStudent(i).equals(
              course.getMainClass().getClassStudentList().getStudent(j))))
          {
            studentsNotInMainClass.addStudent(
                course.getCourseStudentList().getStudent(i));
          }
        }
      }
      for (int i = 0; i < studentsNotInMainClass.size(); i++)
      {
        for (int j = 0; j < classList.size(); j++)
        {
          if (studentsNotInMainClass.getStudent(i).getClassName()
              .equals(classList.getClassByIndex(j).getClassName()))
          {
            if (!(isMainClassStudentsAvailable(classList.getClassByIndex(j),
                startTime, endTime)))
            {
              throw new IllegalArgumentException("otherStudentError");
            }
          }
        }
      }
    }
    return true;
  }

  public void removeStudentFromCourse(String courseName, String studentID)
  {
    for (int i = 0; i < courseList.getNumberOfCourses(); i++)
    {
      if (courseList.getCourse(i).getCourseName().equals(courseName))
      {
        for (int j = 0; j < courseList.getCourse(i).getCourseSize(); j++)
        {
          if (courseList.getCourse(i).getCourseStudentList().getStudent(j)
              .getStudentId().equals(studentID))
          {
            courseList.getCourse(i).getCourseStudentList()
                .removeStudentByIndex(j);
            break;
          }
        }
      }
    }

  }

  public void removeStudentFromVIA(String studentID)
  {
    for (int i = 0; i < studentList.size(); i++)
    {
      if (studentID.equals(studentList.getStudent(i).getStudentId()))
      {
        studentList.removeStudent(studentList.getStudent(i));
      }
      else
      {
        throw new IllegalArgumentException("No such Student ID in system.");
      }
    }

    for (int i = 0; i < courseList.getNumberOfCourses(); i++)
    {
      for (int j = 0; j < courseList.getCourse(i).getCourseSize(); j++)
      {
        if (courseList.getCourse(i).getCourseStudentList().getStudent(j)
            .getStudentId().equals(studentID))
        {
          courseList.getCourse(i).removeStudentFromCourse(
              courseList.getCourse(i).getCourseStudentList().getStudent(j));
        }
      }
    }
  }

  public void addClass(String classID, int semester)
  {
    String classNameChecker = semester + classID;
    for (int i = 0; i < classList.size(); i++)
    {
      if (classList.getClassByIndex(i).getClassName().equals(classNameChecker))
      {
        throw new IllegalArgumentException(
            "Class with same ID already added: " + classList.getClassByIndex(
                i));
      }
    }
    classList.addClass(new Class(classID, semester));
  }

  public void sortStudentsInClasses()
  {
    for (int i = 0; i < studentList.size(); i++)
    {
      for (int j = 0; j < classList.size(); j++)
      {
        if (studentList.getStudent(i).getClassName()
            .equals(classList.getClassByIndex(j).getClassName()))
        {
          classList.getClassByIndex(j)
              .addStudentToClass(studentList.getStudent(i));
        }
      }
    }

  }

  public RoomList getRoomsList()
  {
    return roomList;
  }

  public StudentList getStudentList()
  {
    return studentList;
  }

  public ClassList getClassList()
  {
    return classList;
  }

  public TeacherList getTeacherList()
  {
    return teacherList;
  }

  public CourseList getCourseList()
  {
    return courseList;
  }

  public SessionList getSessionList()
  {
    return sessionList;
  }

  //////    Chr Testing - might be deleted    \\\\\\

  // GetSessionListForXXX (Teacher, main class, Student) - for use in webpage

  public SessionList getSessionListForTeacher(String teacherID)
  {
    SessionList teacherSessionList = new SessionList();
    for (int i = 0; i < sessionList.getNumberOfSessions(); i++)
    {
      for (int j = 0;
           j < sessionList.getSession(i).getCourse().getCourseTeacherList()
               .size(); j++)
        if (sessionList.getSession(i).getCourse().getCourseTeacherList()
            .getTeacher(j).getTeacherId().equals(teacherID))
        {
          teacherSessionList.addSession(sessionList.getSession(i));
        }
    }
    return teacherSessionList;
  }

  public SessionList getSessionListForMainClass(String className)
  {
    SessionList classSessionList = new SessionList();
    for (int i = 0; i < sessionList.getNumberOfSessions(); i++)
    {
      if (sessionList.getSession(i).getCourse().getMainClass().getClassName()
          .equals(className))
      {
        classSessionList.addSession(sessionList.getSession(i));
      }
    }

    return classSessionList;
  }

  public SessionList getSessionListForStudent(String studentID)
  {
    SessionList studentSessionList = new SessionList();
    for (int i = 0; i < sessionList.getNumberOfSessions(); i++)
    {
      for (int j = 0;
           j < sessionList.getSession(i).getCourse().getCourseSize(); j++)
      {
        if (sessionList.getSession(i).getCourse().getCourseStudentList()
            .getStudent(j).getStudentId().equals(studentID))
        {
          studentSessionList.addSession(sessionList.getSession(i));
        }
      }
    }

    return studentSessionList;

  }

  // XML file creation

  public void createSessionListXML()
  {
    XMLParser.toXML(getSessionList(), "sessionlistFull.xml");
  }

  public void createStudentSessionListXML(String studentID)
  {
    if (studentList.contains(getStudentByID(studentID)))
    {
      XMLParser.toXML(getSessionListForStudent(studentID),
          "sessionListStudent" + studentID + ".xml");
    }
  }

  public void createTeacherSessionListXML(String teacherID)
  {
    if (teacherList.contains(getTeacherByID(teacherID)))
    {
      XMLParser.toXML(getSessionListForTeacher(teacherID),
          "sessionListTeacher" + teacherID + ".xml");
    }
  }

  public void createClassSessionListXML(String className)
  {
    if (classList.contains(getClassByID(className)))
    {
      XMLParser.toXML(getSessionListForMainClass(className),
          "sessionListMainClass" + className + ".xml");
    }
  }


  // this one is probably not that useful?? It makes a SessionList for each student at VIA (one .xml file for each student)
  public void createSessionListForAllStudents()
  {
   for (int i = 0; i < studentList.size(); i++)
   {
     XMLParser.toXML(getSessionListForStudent(studentList.getStudent(i).getStudentId()), "sessionListStudent" + studentList.getStudent(i).getStudentId() + ".xml");
   }
  }

  // Available rooms - roomlist, for creating a new session in GUI
  public RoomList getAvailableRooms(DateTime startTime, DateTime endTime)
  {
    RoomList availableRooms = new RoomList();
    for (int i = 0; i < roomList.getNumberOfRooms(); i++)
    {
      if (isRoomAvailable(roomList.getRoom(i), startTime, endTime))
      {
        availableRooms.addRoom(roomList.getRoom(i));
      }
    }

    return availableRooms;

  }
}
