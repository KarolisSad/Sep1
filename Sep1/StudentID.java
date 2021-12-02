public class StudentID implements ViaID
  {
    private int studentId;

    public StudentID(int studentId)
    {
      if (studentId > 0)
      {
        this.studentId = studentId;
      }

      else
      {
        throw new IllegalArgumentException("Student ID should not be less than 1");
      }
    }

    public String getIdAsString()
    {
      return ""+studentId;
    }

    public StudentID copy()
    {
      StudentID other = new StudentID(studentId);
      return other;
    }


  }