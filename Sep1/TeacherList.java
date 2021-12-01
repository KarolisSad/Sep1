import java.util.ArrayList;

public class TeacherList
{

  private ArrayList<Teacher> teachers;

  /**
   * Constructor for TeacherList
   */
  public TeacherList()
  {
    teachers = new ArrayList<>();
  }

  /**
   * Method adds given teacher
   *
   * @param teacher the teacher
   */
  public void addTeacher(Teacher teacher)
  {
    teachers.add(teacher);
  }

  /**
   * Method removes given teacher
   *
   * @param id teachers id
   */
  public void removeTeacherById(String id)
  {
    for (int i = 0; i < teachers.size(); i++)
    {
      if (teachers.get(i).getID().equals(id))
      {
        teachers.remove(i);
        break;
      }
    }
  }

  /**
   * Method to get teacher object
   * @param index the index
   * @return teacher at given index
   */
  public Teacher getTeacher(int index)
  {
    return teachers.get(index);
  }

  /**
   * Method to get copy of TeacherList
   * @return copy of TeacherList
   */
  public ArrayList<Teacher> copy()
  {
    return new ArrayList<Teacher>(teachers);
  }

}
