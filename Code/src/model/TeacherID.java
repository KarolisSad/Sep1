package model;

/**
 * A class representing Teacher ID, which is used as an identifier for Teachers.
 *
 * @author Group 8Y
 * @Version 1.0 - December 2021
 */
public class TeacherID implements ViaID
{
  private String teacherId;

  /**
   * One-argument constructor.
   * Takes Teacher ID given as argument, and stores it as a String.
   * If Teacher ID given in arguments is an empty String, an exception will be thrown.
   *
   * @see Teacher for uses.
   *
   * @param teacherId
   *            The Teacher ID
   */

  public TeacherID(String teacherId)
  {
    if (teacherId.equals(""))
    {
      throw new IllegalArgumentException("Teacher ID should not be empty.");
    }
    else
    {
      this.teacherId = teacherId;
    }
  }

  /**
   * A Copy method.
   * Since Teacher ID implements the VIA ID interface,
   * which has composition-relationships with the Teacher class
   * this method is needed to take a copy of the VIA-ID when you return it.
   *
   * @return a copy of the Teacher ID the method is used on.
   */
  public TeacherID copy()
  {
    TeacherID other = new TeacherID(teacherId);
    return other;
  }

  /**
   * A method returning the Teacher ID as a String for use in constructing Teachers.
   * Since the instance variable taken as an argument in the constructor is already a String,
   * this method returns the instance variable.
   *
   * @return a String containing the Teacher ID.
   */
  public String getIdAsString()
  {
    return teacherId;
  }
}

