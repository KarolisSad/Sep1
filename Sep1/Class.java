public class Class
{
  private char name;
  private int semester;
  StudentList studentList;

  public Class(char name, int semester, StudentList studentList)
  {
    this.name = name;
    this.semester = semester;
    this.studentList = new StudentList();
  }

  public String getClassName()
  {
    return "" + name;
  }

  public String getClassSemester()
  {
    return "" + semester;
  }

  public StudentList getStudentList()
  {
    return studentList;
  }

  public int getNumberOfStudents()
  {
    return studentList.size();
  }

  public void addStudentToClass(Student student)
  {
    studentList.addStudent(student);
  }

  public void removeStudentFromClass(String studentID)
  {
    for (int i = 0; i < studentList.size(); i++)
    {
      if (studentList.getStudent(i).getStudentID.equals(studentID))
      {
        studentList.removeStudent(i);
        break;
      }
    }

    throw new IllegalArgumentException("Student not found");
  }


}
