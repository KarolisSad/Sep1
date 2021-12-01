public class TeacherID
{
  private String teacherID;

  /**
   * Constructor for TeacherID
   *
   * @param teacherID The teacher ID
   */
  public TeacherID(String teacherID)
  {
    this.teacherID = teacherID;
  }

  /**
   * Method to return teachers ID copy
   *
   * @return copy of teachers ID
   */
  public String getIdAsString()
  {
    return copy().teacherID;
  }

  /**
   * Method to return copy of TeacherID
   *
   * @return copy of TeacherID
   */
  public TeacherID copy()
  {
    return new TeacherID(teacherID);
  }
}



