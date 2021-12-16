package mediator;

import model.Class;
import model.*;

public class ScheduleModelManager implements ScheduleModel
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

    importingClasses();
    importingStudentList();
    sortStudentsInClasses();
    roomImports();
    teacherImports();
    courseImports();

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

  @Override public int studentListSize()
  {
    return studentList.size();
  }

  @Override public Student getStudent(int index)
  {
    return studentList.getStudent(index);
  }

  @Override public int sessionListSize()
  {
    return sessionList.getNumberOfSessions();
  }

  @Override public Session getSession(int index)
  {
    return sessionList.getSession(index);
  }

  @Override public Class getClass(int index)
  {
    return classList.getClassByIndex(index);
  }

  @Override public int getClassListSize()
  {
    return classList.size();
  }

  @Override public Teacher getTeacher(int index)
  {
    return teacherList.getTeacher(index);
  }

  @Override public int getTeacherSize()
  {
    return teacherList.size();
  }

  @Override public int getCourseSize()
  {
    return courseList.getNumberOfCourses();
  }

  @Override public Course getCourse(int index)
  {
    return courseList.getCourse(index);
  }

  @Override public Room getRoom(int index)
  {
    return roomList.getRoom(index);
  }

  @Override public int getRoomListSize()
  {
    return roomList.getNumberOfRooms();
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
      int dateMonth, int dateYear, int startHour, int startMinute,
      String roomNumber)
  {
    Session sessionToAdd = new Session(courseList.getCourseByName(courseName),
        sessionLength, new DateTime(new Date(dateDay, dateMonth, dateYear),
        new Time(startHour, startMinute)),
        roomList.getRoomByRoomNumber(roomNumber));
    if (isRoomAvailable(sessionToAdd.getRoom(), sessionToAdd.getStartDateTime(),
        sessionToAdd.getEndDateTime()))
    {
      if (isMainClassStudentsAvailable(sessionToAdd.getCourse().getMainClass(),
          sessionToAdd.getStartDateTime(), sessionToAdd.getEndDateTime())
          && isOtherCourseStudentsAvailable(sessionToAdd.getCourse(),
          sessionToAdd.getStartDateTime(), sessionToAdd.getEndDateTime())
          && isTeacherAvailable(sessionToAdd.getCourse(),
          sessionToAdd.getStartDateTime(), sessionToAdd.getEndDateTime()))
      {
        sessionList.addSession(sessionToAdd);
      }
    }
    else
    {
      throw new IllegalArgumentException("Room " + sessionToAdd.getRoom()
          + " is not available for selected time: "
          + sessionToAdd.getStartDateTime().getDate() + " "
          + sessionToAdd.getStartDateTime().getTime() + " to "
          + sessionToAdd.getEndDateTime().getTime());
    }

    /*

    DateTime sessionStartTime = new DateTime(
        new Date(dateDay, dateMonth, dateYear),
        new Time(startHour, startMinute));

    DateTime sessionEndTime = (this).

    if (isRoomAvailable(roomList.getRoomByRoomNumber(roomNumber),
        sessionStartTime) && isMainClassStudentsAvailable(
        courseList.getCourseByName(courseName).getMainClass(), sessionStartTime,
        sessionEndTime) && isOtherCourseStudentsAvailable(
        courseList.getCourseByName(courseName), sessionStartTime,
        sessionEndTime) && isTeacherAvailable(
        courseList.getCourseByName(courseName), sessionStartTime,
        sessionEndTime))

      sessionList.addSession(
          new Session(courseList.getCourseByName(courseName), sessionLength,
              new DateTime(new Date(dateDay, dateMonth, dateYear),
                  new Time(startHour, startMinute)),
              roomList.getRoomByRoomNumber(roomNumber)));

    else
      throw new IllegalArgumentException("Session not created");

     */
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
    // 1 initialization, n + 1 checks, n increments = 2n + 2
    {
      if (sessionList.getSession(i).getCourse().getMainClass().equals(mainClass)
          && sessionList.getSession(i).getStartDateTime().getDate()
          .equals(startTime.getDate()))
      // For each n: 2 comparisons, 2 ArrayList Get(1 each) = 2 + 2 * n
      {
        if (startTime.getTime()
            .isBefore(sessionList.getSession(i).getEndDateTime().getTime())
            && !(endTime.getTime()
            .isBefore(sessionList.getSession(i).getStartDateTime().getTime())))
        // For each n: 2 comparisons, 2 ArrayList Get (1 each) = 2 + 2 * n
        {
          throw new IllegalArgumentException(
              "Main Class students not available for sessions. Cause: "
                  + sessionList.getSession(i));
        }
        // Throwing an exception would be 1 time unit
      }
    }
    return true; // 1 return = 1
    // Since there is no recursion, we do not need a base case
    // T(n) = 2n + 2 + 2 + 2n + 2 + 2n + 1 + 1 = 8 + 6n
    // 8 + 6n = O(n)
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

  @Override public void removeCourse(Course course)
  {
    courseList.removeCourse(course);
  }

  @Override public void removeCourseBy(String courseName, int ects,
      String className, String teacherId)
  {
    for (int i = 0; i < courseList.getNumberOfCourses(); i++)
    {
      if (courseList.getCourse(i).getCourseName().equals(courseName)
          && courseList.getCourse(i).getEctsPoints() == ects
          && courseList.getCourse(i).getMainClass().getClassName()
          .equals(className) && courseList.getCourse(i).getCourseTeacherList()
          .getTeacher(0).getTeacherId().equals(teacherId))
      {
        courseList.removeCourseByIndex(i);
      }
    }
  }

  @Override public void removeTeacher(Teacher teacher)
  {
    teacherList.removeTeacher(teacher);
  }

  @Override public void removeSessionBy(String roomName, int month, int day,
      int hour, int minute)
  {
    for (int i = 0; i < sessionList.getNumberOfSessions(); i++)
    {
      if (sessionList.getSession(i).getRoom().getRoomNumber().equals(roomName)
          && sessionList.getSession(i).getStartDateTime().getDate().getMonth()
          == month
          && sessionList.getSession(i).getStartDateTime().getDate().getDay()
          == day
          && sessionList.getSession(i).getStartDateTime().getTime().getHour()
          == hour
          && sessionList.getSession(i).getStartDateTime().getTime().getMinute()
          == minute)
      {
        sessionList.removeSessionByIndex(i);
      }
    }
  }

  public void addClass(String classID, int semester)
  {
    Class classToAdd = new model.Class(classID, semester);
    for (int i = 0; i < classList.size(); i++)
    {
      if (classList.getClassByIndex(i).getClassName()
          .equals(classToAdd.getClassName()))
      {
        throw new IllegalArgumentException(
            "Class with same ID already added: " + classList.getClassByIndex(
                i));
      }
    }
    classList.addClass(classToAdd);
  }

  @Override public void getClassFirst()
  {
    System.out.println(classList.size() + " My print");
  }

  public void sortStudentsInClasses()
  {
    for (int i = 0; i < studentList.size(); i++)
      // 1 initialization, n+1 checks, n increments (2n + 2)
    {
      for (int j = 0; j < classList.size(); j++)
        // 1 initialization, n+1 check, n increments (2n +2) * n,
        // as this loop gets run n times by the outer loop.
      {
        if (studentList.getStudent(i).getClassName()
            // 2 * ArrayList Get(1 each), 1 comparison= 3 * n^2
            .equals(classList.getClassByIndex(j).getClassName()))
        {
          classList.getClassByIndex(j)
              // 2 * ArrayList Get(1 each), 1 * ArrayList add(1) = 3 * n^2
              .addStudentToClass(studentList.getStudent(i));
        }
      }     // Since there is no recursion, we do not need a base case
    }       // T(n) = 2n + 2 + 2n + 2 * n + 3 * n^2 + 3 * n^2 =
            // 2 + 6n + 6n^2 = O(n^2)
            // This algorithm runs in quadratic time.
            // We chose to analyze this function because it uses nested for-loops,
    // making it one of the more demanding functions in our code.
  }

  @Override public void removeStudent(Student student)
  {
    studentList.removeStudent(student);
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

  // XML file creation

  public void createSessionListXML()
  {
    ScheduleFile.toXML(getSessionList(), "sessionList.xml");
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

  public void importingStudentList()
  {
    StudentList newList = ScheduleFile.importStudents();
    for (int i = 0; i < newList.size(); i++)
    {
      studentList.addStudent(newList.getStudent(i));
    }
  }

  public void importingClasses()
  {
    ClassList newList = ScheduleFile.importClasses();
    for (int i = 0; i < newList.size(); i++)
    {
      if (!(classList.contains(newList.getClassByIndex(i))))
      {
        classList.addClass(newList.getClassByIndex(i));
      }
    }

  }

  public void teacherImports()
  {
    TeacherList newList = ScheduleFile.importTeachers();
    for (int i = 0; i < newList.size(); i++)
    {
      teacherList.addTeacher(newList.getTeacher(i));
    }
  }

  public void roomImports()
  {
    RoomList newList = ScheduleFile.importRooms();
    for (int i = 0; i < newList.getNumberOfRooms(); i++)
    {
      roomList.addRoom(newList.getRoom(i));
    }
  }

  public void courseImports()
  {
    boolean foundTeacher = false;
    boolean classFound = false;
    CourseList newList = ScheduleFile.importCourses();
    CourseList notAbleToAddCourses = new CourseList();
    for (int i = 0; i < newList.getNumberOfCourses(); i++)
    {
      int indexTeacher = 0;
      int indexClass = 0;
      for (int j = 0; j < teacherList.size(); j++)
      {
        if (newList.getCourse(i).getCourseTeacherList().getTeacher(0)
            .getTeacherId().equals(teacherList.getTeacher(j).getTeacherId()))
        {
          foundTeacher = true;
          indexTeacher = j;

        }
      }
      for (int z = 0; z < classList.size(); z++)
      {
        if (newList.getCourse(i).getMainClass().getSemester()
            == classList.getClassByIndex(z).getSemester() && newList.getCourse(
                i).getMainClass().getClassID()
            .equals(classList.getClassByIndex(z).getClassID()))
        {
          classFound = true;
          indexClass = z;

        }
      }

      if (foundTeacher && classFound)
      {
        courseList.addCourse(new Course(
            newList.getCourse(i).getCourseNameShort(), newList.getCourse(i).getEctsPoints(),
            classList.getClassByIndex(indexClass),
            teacherList.getTeacher(indexTeacher)));
        System.out.println(
            "List of students in course: " + courseList.getCourse(
                    courseList.getNumberOfCourses() - 1).getCourseStudentList()
                .size());
        //  courseList.addCourse(newList.getCourse(i));
        foundTeacher = false;
        classFound = false;
      }
      else
      {
        notAbleToAddCourses.addCourse(newList.getCourse(i));
      }
    }
    //  Gives list for courses that couldn't be added
    System.out.println("Courses that couldn't be added:");
    for (int i = 0; i < notAbleToAddCourses.getNumberOfCourses(); i++)
    {
      System.out.println(notAbleToAddCourses.getCourse(i).getCourseName());
    }
  }

}
