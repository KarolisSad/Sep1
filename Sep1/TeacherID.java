public class TeacherID implements viaID
{
  private String teacherId;

  public TeacherID(String teacherId)
  {
    this.teacherId = teacherId;
  }

  @Override public String getIdAsString()
  {
    return teacherId;
  }

  @Override public viaID Copy()
  {
    return this;
  }
}
