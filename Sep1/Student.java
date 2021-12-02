public class Student
{
  private String name;
  private StudentID studentID;
  private char className;
  private int semester;

  public Student(String name, StudentID studentID, char className, int semester)
  {
    if (name.equals(""))
    {throw new IllegalArgumentException("Name should not be empty.");}
    else {this.name = name;}
    if (studentID == null)
    {
      throw new NullPointerException("Student ID should not be null");
    }
    else {this.studentID = studentID;}
    this.className = className;

    switch (semester)
    {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7: this.semester = semester; break;
      default: throw new IllegalArgumentException("Semester should be an integer between 1-7.");
    }
  }

  public String getStudentId()
  {
    return studentID.getIdAsString();
  }
  public char getClassName()
  {
    return className;
  }
  public int getSemester()
  {
    return semester;
  }



  // TESTING

  public String toString()
  {
    return "Name: " + name + ", StudentID: " + studentID.getIdAsString() + ", Class: " + className + ", Semester: " + semester;
  }


}