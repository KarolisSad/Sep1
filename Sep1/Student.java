public class Student
{
  private String name;
  private StudentID id;

  /**
   * Constructor for Student
   *
   * @param name      the name
   * @param studentID the student ID
   */
  public Student(String name, StudentID studentID)
  {

    if (name == null)
    {
      throw new IllegalArgumentException("Name field can't be empty.");
    }
    else {this.name = name;}

    if (studentID == null)
    {
      throw new IllegalArgumentException("Student must have ID");
    }
    else {this.id = studentID.copy();}


  }

  /**
   * Getter for ID
   * @return Students ID
   */
  public String getId()
  {
    return id.getIdAsString();
  }


  // FOR TESTING

  public String toString()
  {
    return "Students name: " + name + " ID: " + id.getIdAsString();
  }

}
