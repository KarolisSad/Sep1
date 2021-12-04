import java.util.ArrayList;

public class CourseList
{
  private ArrayList<Course> courseList;

  public CourseList()
  {
    this.courseList = new ArrayList<>();
  }

  public void addCourse(Course course)
  {
    courseList.add(course);
  }

  public int getNumberOfCourses()
  {
    return courseList.size();
  }

  public Course getCourse(int index)
  {
    return courseList.get(index);
  }

  public String toString()
  {
    String s = "Courses: \n";
    for (Course i : courseList)
    {
      s += i + "\n";
    }
    return s;
  }
}