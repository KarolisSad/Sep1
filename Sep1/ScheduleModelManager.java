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

  /*
  public void addSession(Course course, int length, DateTime startTime,
      Room room)
  {
    sessionList.addSession(new Session(course, length, startTime, room));
  }

   */
public Class getClassByID(String className)
{
  for (int i = 0; i < classList.size();i++)
  {
    if (classList.getClassByIndex(i).getClassName().equals(className))
    {
      return classList.getClassByIndex(i);
    }
  }
  throw new IllegalArgumentException("Class not found.");
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
  throw new IllegalArgumentException("Teacher not found");
}



  public void addCourse(String name, int ECTS, String mainClass,
      String teacherID)
  {
    Class classToAdd = getClassByID(mainClass);
    Teacher teacherToAdd = getTeacherByID(teacherID);

    for (int i = 0; i < courseList.getNumberOfCourses(); i++)
    {
      if (courseList.getCourse(i).getCourseName().equals(name + classToAdd.getClassID()))
      {
        throw new IllegalArgumentException("Course with same name already added.");
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
      if (studentList.getStudent(i).getStudentId()
          .equals("" + studentID))
      {
        throw new IllegalArgumentException(
            "Student with same ID already added: " + studentList.getStudent(i));
      }
    }
    studentList.addStudent(
        new Student(name, new StudentID(studentID), classID, semester));
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

  //      FOR TESTING     //

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
}
