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
}
