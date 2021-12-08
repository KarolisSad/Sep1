/**
 * Class represents student.
 * @author Group 8.
 */
public class Student
{
  private String name;
  private StudentID studentID;
  private String className;

  /**
   * Four-argument constructor. The first argument (name) is initialized after a check is made to make sure that the name has some sort of value,
   * otherwise it would throw an exception. Second argument (studentID), goes through the same process as the first one. In the constructor,
   * a new variable is created called classNameBuilder to combine semester and class name into one string. Not finished !!!
   *
   * @param name
   * @param studentID
   * @param classID
   * @param semester
   */
  public Student(String name, StudentID studentID, String classID, int semester)
  {
    if (name.equals(""))
    {
      throw new IllegalArgumentException("Name should not be empty.");
    }
    else
    {
      this.name = name;
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
        classNameBuilder += semester;
        break;
      default:
        throw new IllegalArgumentException(
            "Semester should be an integer between 1-7.");
    }

    switch (classID)
    {
      case "x":
        classNameBuilder += "X";
        break;
      case "y":
        classNameBuilder += "Y";
        break;
      case "z":
        classNameBuilder += "Z";
        break;
      case "Y":
      case "X":
      case "Z":
      case "DK":
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

  // TESTING

  /**
   * method is meant to print out student information in a presentable way.
   * @return student infomation (Name of the student and ID).
   */
  public String toString()
  {
    return "Name: " + name + ", StudentID: " + getStudentId();
  }

}