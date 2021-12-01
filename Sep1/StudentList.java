import java.util.ArrayList;

public class StudentList
{
  private ArrayList<Student> studentList;

  public StudentList()
  {
    this.studentList = new ArrayList<>();
  }


  // CHECK ALL OF THESE - SHOULD PROPBABLY BE ADDED IN ASTAH


  public void addStudent(Student student)
  {
    studentList.add(student);
  }


  public void removeStudent(int index)
  {
    studentList.remove(index);
  }

  public int size()
  {
    return studentList.size();
  }

  public Student getStudent(int index)
  {
    return studentList.get(index);
  }


}
