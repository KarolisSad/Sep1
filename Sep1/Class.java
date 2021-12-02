public class Class
{
  private char className;
  private int semester;
  StudentList cStudentList;
  StudentList allStudents;

  public Class(char className, int semester, StudentList allStudents)
  {
    this.className = className;
    this.semester = semester;
    this.cStudentList = new StudentList();
    this.allStudents = allStudents;

  }

  public String getClassName()
  {
    return Character.toString(className);
  }

  public String getClassSemester()
  {
    return "" + semester;
  }

  public StudentList getStudentList()
  {
    return cStudentList.copy();
  }

  public int getNumberOfStudents()
  {
    return cStudentList.size();
  }

  public void addStudentToClass(Student student)
  {
    cStudentList.addStudent(student);
  }

  /**
   * Sorts from list of all students, and puts students with the same semester and class-name into the StudentList for this class.
   *
   */
  public void addStudentsToClass()
  {
    for (int i = 0; i < allStudents.size(); i++)
    {
      if (allStudents.getStudent(i).getClassName() == className && allStudents.getStudent(i).getSemester() == semester)
      {
        cStudentList.addStudent(allStudents.getStudent(i));
      }
    }
  }

  public void removeStudentFromClass(String studentID)
  {
    for (int i = 0; i < cStudentList.size(); i++)
    {
      if (cStudentList.getStudent(i).getStudentId().equals(studentID))
      {
        cStudentList.removeStudentByIndex(i);
        break;
      }
      else throw new IllegalArgumentException("Student not found");
    }

    ;
  }

  /* Might be nice to have
    a toString to crate the real "name" of the class: ex. 1Y
   */
  public String toString()
  {
    String s = "Class: " + getClassName() + ", Semester: " + getClassSemester() + ", Number of students: " + getNumberOfStudents();
    return s;
  }

}
