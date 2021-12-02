import java.util.ArrayList;

public class TeacherList
{
  private ArrayList<Teacher> teacherList;

  public TeacherList()
  {
    this.teacherList = new ArrayList<>();
  }

  public void addTeacher(Teacher teacher)
  {
    if (teacherList.isEmpty())
    {
      teacherList.add(teacher);
    }
    else
    {
      if (teacherList.contains(teacher))
      {
        throw new IllegalArgumentException("Teacher already in system.");
      }
      else
      {
        teacherList.add(teacher);
      }
    }
  }

  public void removeTeacher(Teacher teacher)
  {
    teacherList.remove(teacher);
  }


  public void removeTeacherByID(String teacherID)
  {
    for (int i = 0; i < teacherList.size(); i++)
    {
      if (teacherList.get(i).getID().equals(teacherID))
      {
        teacherList.remove(i);
        break;
      }
    }
  }

  public int size()
  {
    return teacherList.size();
  }

  public Teacher getTeacher(int index)
  {
    return teacherList.get(index);
  }

  public TeacherList copy()
  {
    TeacherList other = new TeacherList();
    for (int i = 0; i < teacherList.size(); i++)
    {
      other.addTeacher(teacherList.get(i));
    }
    return other;
  }


  /*
      MISSING ADD TEACHER BY ID - NOT POSSIBLE HERE??
   */

  // TESTING

  public String toString()
  {
    String s = "Teachers in list:\n";
    for (int i = 0; i < teacherList.size(); i++)
    {
      s += teacherList.get(i) + "\n";
    }
    return s;
  }
}