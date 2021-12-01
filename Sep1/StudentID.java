public class StudentID implements viaID
{
  private int studentId;

  public StudentID(int studentId)
  {
    this.studentId = studentId;
  }

  @Override public String getIdAsString()
  {
    return "" + studentId;
  }

  @Override public viaID Copy()
  {
    return this;
  }
}
