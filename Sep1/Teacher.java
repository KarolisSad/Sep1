/**
 * The class represents teacher, which we use, to create students.
 *
 * @author Group 8.
 * @version 1.0 December 2021
 */
public class Teacher
{
  private String name;
  private TeacherID teacherID;

  /**
   * Two-argument constructor.
   * In the constructor both arguments go through a check if the input is not null (empty).
   * If the input is valid instance variable are initialized, otherwise it throws an exception.
   * @param name name of the teacher.
   * @param teacherID unique string that is generated for teachers.
   */
  public Teacher(String name, TeacherID teacherID)
  {
    if (name == null)
    {
      throw new IllegalArgumentException("Name field can't be empty.");
    }
    else {this.name = name;}

    if (teacherID == null)
    {
      throw new IllegalArgumentException("Teacher must have ID");
    }
    else {this.teacherID = teacherID.copy();}

  }

  /**
   * method meant to get teacher ID as a string.
   * @return teacher ID as a string.
   */
  public String getTeacherId()
  {
    return teacherID.getIdAsString();
  }

  /**
   * method is meant to compare two teacher objects if they are equal to each other.
   * @param obj
   * @return a boolean, true - equal, else - false.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Teacher))
    {return false;}
    Teacher other = (Teacher) obj;
    return name.equals(other.name) && getTeacherId().equals(other.getTeacherId());
  }

  /**
   * method meant for generating well presented Teacher information.
   * @return teacher information.
   */
  public String toString()
  {
    return "Name: " + name + ", Teacher ID: " + getTeacherId();
  }
}
