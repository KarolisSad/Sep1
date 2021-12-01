public class Teacher
{
  private String name;
  private TeacherID id;

  /**
   * Constructor for Teacher
   *
   * @param name      the name
   * @param teacherID the Teacher ID
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
    else {this.id = teacherID.copy();}

  }

  /**
   * Getter for ID
   *
   * @return teachers ID in String format
   */
  public String getID()
  {
    return id.getIdAsString();
  }


  // FOR TESTING

  public String toString()
  {
    return "Teachers name " + name + " ID " + id.getIdAsString();
  }
}
