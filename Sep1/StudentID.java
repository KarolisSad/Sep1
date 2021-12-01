public class StudentID extends ViaID
{

  private int studentID;

  /**
   * Constructor for StudentID
   *
   * @param studentID the Student ID
   */
  public StudentID(int studentID)
  {
    if (studentID != 0)
    {
      this.studentID = studentID;
    }
    else
    {
      throw new IllegalArgumentException("Student ID can't be 0");
    }
  }

  /**
   * Method to return students ID copy
   *
   * @return the copy of ID in string format
   */
  public String getIdAsString()
  {
    return String.valueOf(copy().studentID);
  }

  /**
   * Method to return the copy of StudentID
   *
   * @return copy of StudentID
   */
  public StudentID copy()
  {
    return new StudentID(studentID);

  }


  // Illegal if ID is String
}