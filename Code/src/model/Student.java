package model;
/**
 * Class represents student.
 * @author Group 8.
 */
public class Student
{
  private String studentName;
  private StudentID studentID;
  private String className;
  private String classID;
  private int semester;

  /**
   * Four-argument constructor. The first argument (name) is initialized after a check is made to make sure that the name has some sort of value,
   * otherwise it would throw an exception. Second argument (studentID), goes through the same process as the first one. In the constructor,
   * a new variable is created called classNameBuilder to combine semester and class name into one string. Not finished !!!
   *
   * @param studentName
   * @param studentID
   * @param classID
   * @param semester
   */
  public Student(String studentName, StudentID studentID, String classID, int semester)
  {
    if (studentName.equals(""))
    {
      throw new IllegalArgumentException("Name should not be empty.");
    }
    else
    {
      this.studentName = studentName;
    }
    if (studentID == null)
    {
      throw new NullPointerException("Student ID should not be null");
    }
    else
    {
      this.studentID = studentID;
    }

    String classNameBuilder = "";
    switch (semester)
    {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
        this.semester = semester;
        classNameBuilder += semester;
        break;
      default:
        throw new IllegalArgumentException(
            "Semester should be an integer between 1-7.");
    }

    switch (classID)
    {
      case "x":
        this.classID = classID;
        classNameBuilder += "X";
        break;
      case "y":
        this.classID = classID;
        classNameBuilder += "Y";
        break;
      case "z":
        this.classID = classID;
        classNameBuilder += "Z";
        break;
      case "Y":
      case "X":
      case "Z":
      case "DK":
        this.classID = classID;
        classNameBuilder += classID;
        break;
      default:
        throw new IllegalArgumentException(
            "ClassID should be one of the following: X, Y, Z or DK");
    }

    this.className = classNameBuilder;

  }
  /**
   * method is meant to get a student ID of specified student.
   * @return specified students ID as a string.
   */
  public String getStudentId()
  {
    return studentID.getIdAsString();
  }
  /**
   * method is meant to call a name of a specified class.
   * @return class name of specified class.
   */
  public String getClassName()
  {
    return className;
  }

  /**
   * Method for getting a students name
   * @return String holding students name
   */
  public String getName()
  {
    return studentName;
  }

  /**
   * Method for getting the class ID assigned to a student
   * @return String holding students class ID
   */
  public String getClassID()
  {
    return classID;
  }

  /**
   * Method for getting the semester assigned to a student
   * @return String holding students semester
   */
  public int getSemester()
  {
    return semester;
  }


  /**
   * method is meant to print out student information in a presentable way.
   * @return student infomation (Name of the student and ID).
   */
  public String toString()
  {
    return "Name: " + studentName + ", StudentID: " + getStudentId();
  }

}