import java.util.ArrayList;

public class StudentList
{
  private ArrayList<Student> studentList;

  public StudentList()
  {
    this.studentList = new ArrayList<>();
  }

  public void addStudent(Student student)
  {
    if (studentList.isEmpty())
    {
      studentList.add(student);
    }
    else
    {
      if (studentList.contains(student))
      {
        throw new IllegalArgumentException("Student already in system.");
      }
      else
      {
        studentList.add(student);
      }
    }
  }

  public void removeStudent(Student student)
  {
    studentList.remove(student);
  }

  public void removeStudentByIndex(int index)
  {
    studentList.remove(index);
  }

  public void removeStudentByID(String studentID)
  {
    for (int i = 0; i < studentList.size(); i++)
    {
      if (studentList.get(i).getStudentId().equals(studentID))
      {
        studentList.remove(i);
        break;
      }
    }
  }

  public int size()
  {
    return studentList.size();
  }

  public Student getStudent(int index)
  {
    return studentList.get(index);
  }

  public StudentList copy()
  {
    StudentList other = new StudentList();
    for (int i = 0; i < studentList.size(); i++)
    {
      other.addStudent(studentList.get(i));
    }
    return other;
  }

  // TESTING

  public String toString()
  {
    String s = "Students in list:\n";
    for (int i = 0; i < studentList.size(); i++)
    {
      s += studentList.get(i) + "\n";
    }
    return s;
  }
}

