
public class TeacherID implements ViaID //implements an interface
{
  private String teacherID;

  public TeacherID(String teacherID)
  {
    if (teacherID.equals(""))
    {
      throw new IllegalArgumentException("Teacher ID should not be empty.");
    }
    else
    {
      this.teacherID = teacherID;
    }
  }

  public TeacherID copy()
  {
    TeacherID other = new TeacherID(teacherID);
    return other;
  }

  public String getIdAsString() //id is already a string
  {
    return teacherID;
  }
}

