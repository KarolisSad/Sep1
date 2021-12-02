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


  // EQUALS

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Teacher))
    {return false;}
    Teacher other = (Teacher) obj;
    return name.equals(other.name) && id.equals(other.id);
  }


  // FOR TESTING

  public String toString()
  {
    return "Name: " + name + ", Teacher ID: " + id.getIdAsString();
  }
}
