import java.util.ArrayList;

public class StudentList
{

  private ArrayList<Student> students;

  /**
   * Constructor for StudentList
   */
  public StudentList()
  {
    students = new ArrayList<>();
  }

  /**
   * Adds Student to the list
   *
   * @param student the student
   */
  public void addStudent(Student student)
  {
    students.add(student);
  }

  /**
   * Remove student from list by ID
   *
   * @param Id students ID
   */
  public void removeStudentByID(String Id)
  {
    for (int i = 0; i < students.size(); i++)
    {
      if (students.get(i).getId().equals(Id))
      {
        students.remove(i);
        break;
      }
    }
  }

  /**
   * Method to remove student by index number
   * @param index index
   */
  public void removeStudent(int index)
  {
    students.remove(index);
  }

  /**
   * Method for getting student
   * @param index the index
   * @return the student
   */
  public Student getStudent(int index)
  {
    return students.get(index);
  }

  /**
   * Method to get copy of StudentList
   * @return copy of StudentList
   */
  public ArrayList<Student> copy()
  {
    return new ArrayList<Student>(students);
  }

  /**
   * Method to return studentList size
   * @return StudentList size
   */
  public int size()
  {
    return students.size();
  }




}
