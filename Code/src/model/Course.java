package model;

/**
 * The class represents courses.
 *
 * @author Group 8
 */
public class Course
{
  private String courseNameShort;
  private String courseName;
  private int ectsPoints;
  private TeacherList courseTeacherList;
  private StudentList courseStudentList;
  private Class mainClass;

  /**
   * Four-argument constructor. In the constructor all four instance variables are initialized. Before they are initialized each argument goes
   * through a check to make sure that the inputs are valid. The first argument (ectsPoints) goes through a check with an if statement to make
   * sure that entered values are either 5 or 10 otherwise it will throw an exception. The second argument (mainClass) goes through an if-statement
   * check to make sure that class has a value, otherwise - throws an exception. The third argument (courseName) goes through an if-statement
   * check to make sure that the course name was entered, otherwise it throws an exception. The last argument (teacher) goes through an if-statement
   * check to make sure that there is a teacher is chosen from the dropdown list, otherwise it throws an exception.
   * There is created a new array list that will contain teachers for specified course and after the teacher argument is checked for an input
   * it is initialized as part of course teacher array list.
   * A student list array is created as a new student list for specified course.
   *
   * @param courseNameShort short version of the course name (ex. SDJ1)
   * @param ectsPoints      ECTS points for the course.
   * @param mainClass       class that will be assigned to the course.
   * @param teacher         teacher or teachers that are assigned to the course.
   */
  public Course(String courseNameShort, int ectsPoints, Class mainClass,
      Teacher teacher)
  {
    if (ectsPoints == 5 || ectsPoints == 10)
    {
      this.ectsPoints = ectsPoints;
    }
    else
    {
      throw new IllegalArgumentException("ECTS points should be 5 or 10");
    }

    if (mainClass == null)
    {
      throw new NullPointerException("ERROR CLASS");
    }
    else
    {
      this.mainClass = mainClass;
    }

    if (courseNameShort.equals(""))
    {
      throw new IllegalArgumentException("Course Name should not be empty.");
    }
    else
    {
      this.courseNameShort = courseNameShort;
      this.courseName = courseNameShort + mainClass.getClassName();
    }

    this.courseTeacherList = new TeacherList();
    this.courseStudentList = mainClass.getClassStudentList();

    if (teacher == null)
    {
      throw new NullPointerException(
          "Error Teacher - course needs at least one teacher");
    }
    else
    {
      this.courseTeacherList.addTeacher(teacher);
    }

  }

  /**
   * method intended to call course name.
   *
   * @return course name of a specified course.
   */
  public String getCourseName()
  {
    return courseName;
  }

  public String getCourseNameShort()
  {
    return courseNameShort;
  }

  /**
   * method intended to call a list of students that belong to said course.
   *
   * @return list of students that belong to the course;
   */
  public StudentList getCourseStudentList()
  {
    return courseStudentList;
  }

  /**
   * method intended to call a list of teachers that are assigned to said course.
   *
   * @return list of teachers that belong to the course.
   */
  public TeacherList getCourseTeacherList()
  {
    return courseTeacherList;
  }

  /**
   * method intended to get the size of an array list.
   *
   * @return a number of items in a specified array list.
   */
  public int getCourseSize()
  {
    return courseStudentList.size();
  }

  /**
   * method meant to add a new student to a course student list.
   *
   * @param student student object that will be added to an array list
   */
  public void addStudentToCourse(Student student)
  {
    courseStudentList.addStudent(student);
  }

  /**
   * A getter for the instance variable ECTS-points.
   *
   * @return integer-value ECTS-point given as an argument in constructor.
   */
  public int getEctsPoints()
  {
    return ectsPoints;
  }

  /**
   * method intended to call class of specified course.
   *
   * @return class that belongs to specified course.
   */
  public Class getMainClass()
  {
    return mainClass;
  }

  /**
   * method meant to remove a student from a course student list.
   *
   * @param student student object that will be removed from an array list
   */
  public void removeStudentFromCourse(Student student)
  {
    courseStudentList.removeStudent(student);
  }

  /**
   * method meant to add a new teacher to a course teacher list.
   *
   * @param teacher teacher object that will be added to an array list
   */
  public void addTeacherToCourse(Teacher teacher)
  {
    courseTeacherList.addTeacher(teacher);
  }

  /**
   * method meant to remove a teacher from a course teacher list.
   * Inside the method if-statement is used to check if an array list contain more than one teacher, since there always must be at least one,
   * otherwise it throws an exception, to make sure that a new teacher is added before the old one is removed.
   *
   * @param teacher teacher object that will be from an array list
   */
  public void removeTeacherFromCourse(Teacher teacher)
  {
    if (courseTeacherList.size() > 1)
    {
      courseTeacherList.removeTeacher(teacher);
    }
    else
    {
      throw new IllegalArgumentException(
          "Course needs to have a minimum of 1 teacher. Add a new teacher before removing.");
    }
  }

  /**
   * method is meant to compare two Course objects if they are equal to each other.
   *
   * @param obj
   * @return a boolean (true of false) if the objects are same or not.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Course))
    {
      return false;
    }
    Course other = (Course) obj;
    return courseName.equals(other.courseName) && ectsPoints == other.ectsPoints
        && courseTeacherList.equals(other.courseTeacherList)
        && courseStudentList.equals(other.courseStudentList);
  }

  /**
   * Method intended to be used to when it's called to print out the content of a certain course in a readable manner.
   *
   * @return Information about the course.
   */
  public String toString()
  {
    return "Course: " + courseName + ", Number of students: "
        + getCourseStudentList().size() + ", " + getCourseTeacherList() + "\n";
  }

}
