package mediator;

import model.*;
import file.ScheduleFile;
import model.Class;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class representing Schedule manager, which stores all array lists that created in list classes.
 *
 * @author Group 8.
 * @version 1.0 December 2021.
 */
public class ScheduleModelManager implements ScheduleModel
{
  private RoomList roomList;
  private SessionList sessionList;
  private CourseList courseList;
  private TeacherList teacherList;
  private StudentList studentList;
  private ClassList classList;

  /**
   * Six-argument constructor.
   * In the constructor we initialize the instance variables as a new array lists,
   * that will store a lists of rooms, sessions, courses, teacher,students and classes.
   * when the constructor initialized, the import methods are called.
   */
  public ScheduleModelManager()
  {
    this.roomList = new RoomList();
    this.sessionList = new SessionList();
    this.courseList = new CourseList();
    this.teacherList = new TeacherList();
    this.studentList = new StudentList();
    this.classList = new ClassList();
    // imports

    importingClasses();
    importingStudentList();
    sortStudentsInClasses();
    roomImports();
    teacherImports();
    courseImports();
    importSessions();
  }

  /**
   * method is meant to add room to a room array list.
   * In the method, it's looped through the array list to check if the room doesn't already exists
   * and if not then added to the list. If the room already exists it will throw an exception.
   * @param capacity how many people fit in the room.
   * @param roomNumber room name.
   */
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

  /**
   * method is meant for getting a class by class name (ID).
   * In the method, it's looped through the array list and inside each array list item is compared
   * with the class name of the class that suppose to be printed out.
   * If the class doesn't exist, it will throw an exception.
   * @param className class name that needs to be returned.
   * @return
   */
  public model.Class getClassByID(String className)
  {
    for (int i = 0; i < classList.size(); i++)
    {
      if (classList.getClassByIndex(i).getClassName().equals(className))
      {
        return classList.getClassByIndex(i);
      }
    }
    throw new IllegalArgumentException("Class not found.");
  }

  /**
   * method is meant for getting a teacher by teacher ID.
   * In the method, it's looped through the array list and inside each array list item is compared
   * with the teacher ID of the teacher that suppose to be printed out.
   * If the teacher doesn't exist, it will throw an exception.
   * @param teacherID unique string that each teacher is assigned.
   * @return teacherID as a string.
   */
  public Teacher getTeacherByID(String teacherID)
  {
    for (int i = 0; i < teacherList.size(); i++)
    {
      if (teacherList.getTeacher(i).getTeacherId().equals(teacherID))
      {
        return teacherList.getTeacher(i);
      }
    }
    throw new IllegalArgumentException("Teacher not found");
  }

  /**
   * method is meant for adding a course to the course list.
   * In the method, two methods from CourseList and TeacherList are called to get class and teacher.
   * For-loop is used to loop through the array list, that the course suppose to be added to, to check if the course
   * doesn't already exist in the array list. If it does it throws an exception.
   * Otherwise, it calls the adCourse() from CourseList class and adds the course.
   * @param name name of the course.
   * @param ECTS how many points does the course have.
   * @param mainClass the class that is assigned to that course.
   * @param firstTeacherID the teacher that is assigned to tha course
   */
  public void addCourse(String name, int ECTS, String mainClass,
      String firstTeacherID)
  {
    model.Class classToAdd = getClassByID(mainClass);
    Teacher teacherToAdd = getTeacherByID(firstTeacherID);

    for (int i = 0; i < courseList.getNumberOfCourses(); i++)
    {
      if (courseList.getCourse(i).getCourseName()
          .equals(name + classToAdd.getClassName()))
      {
        throw new IllegalArgumentException(
            "Course with same name already added.");
      }
    }
    courseList.addCourse(new Course(name, ECTS, classToAdd, teacherToAdd));

  }

  /**
   * method meant to add a teacher to a teacher list.
   * In the method, it's looped through a teacher array list to make sure that
   * the teacher that is supposed to be added does not already exist in the list.
   * If it does already exist exception is thrown.
   * Otherwise, addTeacher() is called from TeacherList class and the teacher is added.
   * @param name teacher name.
   * @param teacherID unique string generate for each teacher.
   */
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

  /**
   * method meant to add a student to a student list.
   * In the method, it's looped through a student array list to make sure that
   * the student that is supposed to be added does not already exist in the list.
   * If it does already exist exception is thrown.
   * Otherwise, addStudent() is called from StudentList class and the student is added.
   * @param name student name.
   * @param studentID unique number generate for each student.
   */
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

  /**
   * method is meant to add a session to the session array list.
   * CHRISTIAN MUST LOOK AT THE FIRST PART WITH DATE.
   * In the method, session goes through several checks before it's added.
   * It is checked if the chosen room for the session is available, are the student that are assigned to that session are available
   * and if teachers assigned are available.
   * If the checks are true the session is added to the session array list. Otherwise, it will throw an exception.
   * @param courseName course that is assigned to the session.
   * @param sessionLength how long will the session take place.
   * @param dateDay the day that the session will take place.
   * @param dateMonth the month, the session will take place.
   * @param dateYear the year, the session will take place.
   * @param timeHour hour of the day.
   * @param timeMinute minute of the day.
   * @param roomNumber location for the session.
   */
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
  }

  /**
   * method is meant to check if the room is available for the chosen session.
   * In the method, it's looped through the session array list to check which rooms are booked for the session at a certain date.
   * If the room is taken, in the nested if-statement it's checked if the booked room is available at a certain time period.
   * @param room room that is checked, if available.
   * @param startTime start time of the session.
   * @param endTime end time of the session
   * @return boolean, if available - true, else - false.
   */
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
          throw new IllegalArgumentException(
              "Room already in use for selected time. Room used by: "
                  + sessionList.getSession(i));
        }
      }
    }
    return true;
  }

  /**
   * method is meant to call a room by its number.
   * @param roomNumber the number of the room that is suppose to be returned.
   * @return the room with a specified number.
   */
  public Room getRoomByNumber(String roomNumber)
  {
    return roomList.getRoomByRoomNumber(roomNumber);
  }

  /**
   * method is meant to check if the students of a certain class are available for a session.
   * In the method, it's looped through the session array list to check created session for a certain class and
   * check if that class is booked for a certain time of the day. If it's booked it will throw an exception.
   * @param mainClass the class that that is checked, if available.
   * @param startTime start time of a session.
   * @param endTime end time of a session.
   * @return boolean, if available - true, else - false.
   */
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

  /**
   * method is meant to check if the teacher is available for a certain session.
   * In the method, it's looped through the session array list to check created session for a certain teacher and
   * check if that teacher is booked for a certain time of the day. If it's booked it will throw an exception.
   * @param course the course that teacher is assigned to.
   * @param startTime start time of a session.
   * @param endTime ent time of a session.
   * @return boolean, if available - true, else - false.
   */
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

  /**
   * method is meant to check if students that are not in the same class, but in the same course are available for a certain session.
   * In the method, in the first step, it is checked if the course students are same students as the class students otherwise,
   * two for-loops with nested for-loops are run. The first loop is meant to add a student that is not belong to the main class to a new array list.
   * In the second loop it is checked if the student that is not in the main class is available for the course session.
   * If student is not available it will throw an exception.
   * @param course course that students are assigned to.
   * @param startTime start time of a session.
   * @param endTime end time of a session.
   * @return boolean, if available - true, else - false.
   */
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

  /**
   * method is meant to remove students from a course.
   * In the method, it's looped through the course array list to find the name of a course that student has to be removed from.
   * In the nested for loop, it's looped through the students in the course and if the student that needs to be removed is in the course,
   * it's removed and loops break.
   * @param courseName course name that the student needs to removed from.
   * @param studentID a unique number the student, that needs to be removed, has.
   */
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

  /**
   * method is meant to remove student object from all student lists, that the student belongs to.
   * In the method it's looped through the student array list of all students, checked if the
   * student with the given ID is in the list and if so student is removed.
   * Following that, the nested loop goes through all courses to find the said student and if it is found
   * the student will be removed.
   * @param studentID student ID of the student, that suppose to be removed.
   */
  public void removeStudentFromVIA(String studentID)
  {
    for (int i = 0; i < studentList.size(); i++)
    {
      if (studentID.equals(studentList.getStudent(i).getStudentId()))
      {
        studentList.removeStudent(studentList.getStudent(i));
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

  /**
   * method is meant to add a class to a class array list.
   * In the method, it's looped through an existing class array list and a check is made if the class that suppose to be added
   * does not already exists in the list. If it does exception is thrown. Otherwise, it's added to the array list.
   * @param classID one letter, that represents a class.
   * @param semester semester that the class is in.
   */
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

  public StudentList getCourseStudentList(Course course)
  {
    return course.getCourseStudentList();
  }

  /**
   * method is meant to sort students by class.
   * In the method, it's looped through the student list and in the nested loop, it's looped through the class list.
   * In side the nested loop, a check is made if the student object has the same class name as the class that it is checked against,
   * if it does the student is added.
   */
  public void sortStudentsInClasses()
  {
    for (int i = 0; i < studentList.size(); i++)
    {
      for (int j = 0; j < classList.size(); j++)
      {
        if (studentList.getStudent(i).getClassName()
            .equals(classList.getClassByIndex(j).getClassName()) &&
            // don't add student if he's already in a list (class)
            !(classList.getClassByIndex(j).contains(studentList.getStudent(i))))
        {
          classList.getClassByIndex(j)
              .addStudentToClass(studentList.getStudent(i));
        }
      }
    }

  }

  /**
   * method is meant to call room array list.
   * @return room array list
   */
  public RoomList getRoomsList()
  {
    return roomList;
  }

  /**
   * method is meant to call student array list.
   * @return student array list
   */
  public StudentList getStudentList()
  {
    return studentList;
  }

  /**
   * method is meant to call class array list.
   * @return class array list
   */
  public ClassList getClassList()
  {
    return classList;
  }

  /**
   * method is meant to call teacher array list.
   * @return teacher array list
   */
  public TeacherList getTeacherList()
  {
    return teacherList;
  }

  /**
   * method is meant to call course array list.
   * @return course array list
   */
  public CourseList getCourseList()
  {
    return courseList;
  }

  /**
   * method is meant to call session array list.
   * @return session array list
   */
  public SessionList getSessionList()
  {
    return sessionList;
  }

  /**
   * method is meant to output available rooms.
   * In the method it's looped through all the room array list and checked if the room is available
   * and if the room is available it's added to a new available room array list.
   * @param startTime start time of a session.
   * @param endTime time when session ends.
   * @return list of available rooms.
   */
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
  /** for testing
  public void getClassFirst()
  {
    System.out.println(classList.size() + " My print");
  }
   **/

  /**
   * method is meant to return amount of student in the student array list.
   * @return number of students in the array list.
   */
  public int studentListSize()
  {
    return studentList.size();
  }

  /**
   * method is meant call a student by index.
   * @param index position of student object in the array list.
   * @return student.
   */
  public Student getStudent(int index)
  {
    return studentList.getStudent(index);
  }

  /**
   * method meant to return how many sessions are in the session array list.
   * @return number of sessions in the array list.
   */
  public int sessionListSize()
  {
    return sessionList.getNumberOfSessions();
  }

  /**
   * method is meant to get a session by index.
   * @param index position of a session in an array list.
   * @return session.
   */
  public Session getSession(int index)
  {
    return sessionList.getSession(index);
  }

  /**
   * method is meant to import students from the text file.
   */
  public void importingStudentList()
  {
    StudentList newList = ScheduleFile.importStudents();
    for (int i = 0; i < newList.size(); i++)
    {
      studentList.addStudent(newList.getStudent(i));
    }
  }

  /**
   * method is meant to call a class by index from a class list.
   * model. is used to specify that Class is our created object.
   * @param index possition of the class in an array list.
   * @return class
   */
  public model.Class getClass(int index)
  {
    return classList.getClassByIndex(index);
  }

  /**
   * method is meant to return how many classes are in the class array list.
   * @return number of classes in an array list.
   */
  public int getClassListSize()
  {
    return classList.size();
  }

  /**
   * method is meant to import classes from the text file.
   */
  public void importingClasses()
  {
    ClassList newList = ScheduleFile.importClasses();
    for (int i = 0; i < newList.size(); i++)
    {
      classList.addClass(newList.getClassByIndex(i));
    }
  }

  /**
   * method is meant to call a teacher by index from a teacher list.
   * @param index position of the teacher in an array list.
   * @return teacher
   */
  public Teacher getTeacher(int index)
  {
    return teacherList.getTeacher(index);
  }

  /**
   * method is meant to return how many teachers are in the teacher array list.
   * @return number of teachers in an array list.
   */
  public int getTeacherSize()
  {
    return teacherList.size();
  }

  /**
   * method is meant to import teachers from the text file.
   */
  public void teacherImports()
  {
    TeacherList newList = ScheduleFile.importTeachers();
    for (int i = 0; i < newList.size(); i++)
    {
      teacherList.addTeacher(newList.getTeacher(i));
    }
  }

  /**
   * method is meant to return how many courses are in the course array list.
   * @return number of courses in an array list.
   */
  public int getCourseSize()
  {
    return courseList.getNumberOfCourses();
  }

  /**
   * method is meant to call a course by index from a course list.
   * @param index position of the course in an array list.
   * @return course
   */
  public Course getCourse(int index)
  {
    return courseList.getCourse(index);
  }

  /**
   * method is meant to call a course by its name.
   * @param courseName name of the course.
   * @return course.
   */
  @Override public Course getCourseByName(String courseName)
  {
    return courseList.getCourseByName(courseName);
  }

  /**
   * method is meant to call a room by index from a room list.
   * @param index position of the room in an array list.
   * @return room
   */
  public Room getRoom(int index)
  {
    return roomList.getRoom(index);
  }

  /**
   * method is meant to return how many room are in the room array list.
   * @return number of room in an array list.
   */
  public int getRoomListSize()
  {
    return roomList.getNumberOfRooms();
  }

  /**
   * method is meant to import teachers from the text file.
   */
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
        courseList.addCourse(
            new Course(newList.getCourse(i).getCourseNameShort(),
                //getCourseNameShort()
                //            +classList.getClassByIndex(indexClass).getSemester()+classList.getClassByIndex(indexClass).getClassID(),
                newList.getCourse(i).getEctsPoints(),
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
      System.out.println(notAbleToAddCourses.getCourse(i).getCourseNameShort()
          + notAbleToAddCourses.getCourse(i).getMainClass().getSemester()
          + notAbleToAddCourses.getCourse(i).getMainClass().getClassID());
    }
  }

  /**
   * method is meant to import teachers from the text file.
   */
  public void importSessions()
  {
    for (int i = 0; i < ScheduleFile.importSessions().getNumberOfSessions(); i++)
    {
      sessionList.addSession(ScheduleFile.importSessions().getSession(i));

    }
  }

  /**
   * method is meant to remove student from a student array list.
   * @param student the student that is supposed to be removed.
   */
  public void removeStudent(Student student)
  {
    studentList.removeStudent(student);
  }

  /**
   * method is meant to remove course from a course array list.
   * @param course the course that is supposed to be removed.
   */
  public void removeCourse(Course course)
  {
    courseList.removeCourse(course);
  }

  /**
   * method is meant to remove course by its name from a course array list.
   * it's looped through all the courses to find a course that needs to be removed
   * if the course is found it will be removed, else it throws an exception.
   * @param courseName name of the course that is supposed to be removed.
   */
  public void removeCourseBy(String courseName)
  {
    for (int i = 0; i < courseList.getNumberOfCourses(); i++)
    {
      if (courseList.getCourse(i).getCourseName().equals(courseName))
      {
        courseList.removeCourseByIndex(i);
      }
      else
      {
        throw new IllegalArgumentException("Course not found");
      }
    }
  }

  /**
   * method is meant to remove teacher from a teacher array list.
   * @param teacher the teacher that is supposed to be removed.
   */
  public void removeTeacher(Teacher teacher)
  {
    teacherList.removeTeacher(teacher);
  }

  /**
   * method is meant to remove session by certain parameters from the session array list.
   * It's looped through all the sessions and checked against given parameters.
   * If session is found, it'd removed.
   * @param roomName name of the room.
   * @param month month when session takes place.
   * @param day  day when session takes place.
   * @param hour  hour when session takes place.
   * @param minute minute when session takes place.
   */
  public void removeSessionBy(String roomName, int month, int day, int hour,
      int minute)
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

  /**
   * exporting sessions to an XML file.
   */
  @Override public void createSessionListXML()
  {
    ScheduleFile.toXML(getSessionList(), "sessionList.xml");
  }

  /**
   * method is meant to add student to a course.
   * @param studentID student's ID
   * @param courseName name of the course
   */
  public void addStudentToCourse(String studentID, String courseName)
  {
    int nr = 0;
    for (int i = 0; i < studentList.size(); i++)
    {
      if (studentList.getStudent(i).getStudentId().equals(studentID))
      {
        for (int j = 0; j < courseList.getNumberOfCourses(); j++)
        {
          if (courseList.getCourse(j).getCourseName().equals(courseName)
              && (courseList.getCourse(j).getCourseStudentList()
              .containsById(Integer.parseInt(studentID))))
          {
            courseList.getCourse(j)
                .addStudentToCourse(studentList.getStudent(i));
            nr = 1;
            break;
          }
        }
      }
    }
    if (nr == 0)
    {
      throw new IllegalArgumentException("Student is already in this course!");
    }

  }

  /**
   * method is meant to call the export methods to export all the data to text files.
   */
  public void exportAll()
  {
    exportClass();
    exportStudents();
    exportRooms();
    exportTeachers();
    exportCourses();
    exportSessions();
  }

  /**
   * method that is meant to export class list to text file
   */
  public void exportClass()
  {
    File file = new File("classes.txt");
    try
    {
      PrintWriter out = new PrintWriter(file);
      for (int i = 0; i < classList.size(); i++)
      {
        out.print(classList.getClassByIndex(i).getClassID());
        out.print(",");
        out.print(classList.getClassByIndex(i).getSemester());
        out.println();
      }
      out.flush();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    finally
    {
      System.out.println(file.getAbsolutePath());
    }
  }

  /**
   * method that is meant to export student list to text file
   */
  public void exportStudents()
  {
    File file = new File("student.txt");
    try
    {
      PrintWriter out = new PrintWriter(file);
      for (int i = 0; i < studentList.size(); i++)
      {
        out.print(studentList.getStudent(i).getSemester());
        out.print(",");
        out.print(studentList.getStudent(i).getClassID());
        out.print(",");
        out.print(studentList.getStudent(i).getName());
        out.print(",");
        out.print(studentList.getStudent(i).getStudentId());
        out.println();
      }
      out.flush();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    finally
    {
      System.out.println(file.getAbsolutePath());
    }
  }

  /**
   * method that is meant to export room list to text file
   */
  public void exportRooms()
  {
    File file = new File("rooms.txt");
    try
    {
      PrintWriter out = new PrintWriter(file);
      for (int i = 0; i < roomList.getNumberOfRooms(); i++)
      {
        out.print(roomList.getRoom(i).getRoomNumber());
        out.print(",");
        out.print(roomList.getRoom(i).getCapacity());
        out.println();
      }
      out.flush();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    finally
    {
      System.out.println(file.getAbsolutePath());
    }
  }

  /**
   * method that is meant to export teacher list to text file
   */
  public void exportTeachers()
  {
    File file = new File("teachers.txt");
    try
    {
      PrintWriter out = new PrintWriter(file);
      for (int i = 0; i < teacherList.size(); i++)
      {
        out.print(teacherList.getTeacher(i).getName());
        out.print(",");
        out.print(teacherList.getTeacher(i).getTeacherId());
        out.println();
      }
      out.flush();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    finally
    {
      System.out.println(file.getAbsolutePath());
    }
  }

  /**
   * method that is meant to export course list to text file
   */
  public void exportCourses()
  {
    File file = new File("courses.txt");
    try
    {
      PrintWriter out = new PrintWriter(file);
      for (int i = 0; i < courseList.getNumberOfCourses(); i++)
      {
        out.print(courseList.getCourse(i).getMainClass().getSemester());
        out.print(",");
        out.print(courseList.getCourse(i).getMainClass().getClassID());
        out.print(",");
        out.print(courseList.getCourse(i).getCourseNameShort());
        out.print(",");
        out.print(courseList.getCourse(i).getCourseTeacherList().getTeacher(0)
            .getTeacherId());
        out.print(",");
        out.print(courseList.getCourse(i).getEctsPoints());
        out.println();
      }
      out.flush();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    finally
    {
      System.out.println(file.getAbsolutePath());
    }
  }

  /**
   * method that is meant to export session list to text file
   */
  public void exportSessions()
  {
    File file = new File("sessions.txt");
    try
    {
      PrintWriter out = new PrintWriter(file);
      for (int i = 0; i < sessionList.getNumberOfSessions(); i++)
      {
        out.print(sessionList.getSession(i).getCourse().getCourseNameShort());
        out.print(",");
        out.print(sessionList.getSession(i).getSessionLength());
        out.print(",");
        out.print(
            sessionList.getSession(i).getStartDateTime().getDate().getDay());
        out.print(",");
        out.print(
            sessionList.getSession(i).getStartDateTime().getDate().getMonth());
        out.print(",");
        out.print(
            sessionList.getSession(i).getStartDateTime().getDate().getYear());
        out.print(",");
        out.print(
            sessionList.getSession(i).getStartDateTime().getTime().getHour());
        out.print(",");
        out.print(
            sessionList.getSession(i).getStartDateTime().getTime().getMinute());
        out.print(",");
        out.print(sessionList.getSession(i).getRoom().getRoomNumber());
        out.print(",");
        out.print(sessionList.getSession(i).getRoom().getCapacity());
        out.print(",");
        out.print(sessionList.getSession(i).getCourse().getEctsPoints());
        out.print(",");
        out.print(
            sessionList.getSession(i).getCourse().getMainClass().getClassID());
        out.print(",");
        out.print(
            sessionList.getSession(i).getCourse().getMainClass().getSemester());
        out.print(",");
        out.print(sessionList.getSession(i).getCourse().getCourseTeacherList()
            .getTeacher(0).getName());
        out.print(",");
        out.print(sessionList.getSession(i).getCourse().getCourseTeacherList()
            .getTeacher(0).getTeacherId());
        out.println();

      }
      out.flush();
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    finally
    {
      System.out.println(file.getAbsolutePath());
    }
  }

}
