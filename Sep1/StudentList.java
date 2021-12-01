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
   * Remove student from list
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

}
