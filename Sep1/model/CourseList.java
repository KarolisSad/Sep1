package model;

import java.util.ArrayList;
/**
 * The class represents CourseList that stores list of courses as well as a few methods that interact with said list.
 * @author Group 8
 */
public class CourseList
{
  private ArrayList<Course> courseList;

  /**
   * One-argument constructor. In the constructor we initialize the instance variable as a new array list that will store a list of courses.
   */
  public CourseList()
  {
    this.courseList = new ArrayList<>();
  }

  /**
   * method is meant for adding a new course to the course list.
   * @param course a course object that needs to be added.
   * does not return anything as it is a void method.
   */
  public void addCourse(Course course)
  {
    courseList.add(course);
  }

  /**
   * method intended for to get course by name.
   * In the method, for-loop is used to loop through all course list items
   * and if-statement inside the loop to compare the needed course name with
   * course names in the course list. If a name does not exist the exception will be thrown.
   * @param courseName the course with the name that needs to be found
   * @return the course with the specified name of an exception.
   */
  public Course getCourseByName(String courseName)
  {
    for (int i = 0; i < courseList.size(); i++)
    {
      if (courseList.get(i).getCourseName().equals(courseName))
      {
        return courseList.get(i);
      }
    }

    throw new IllegalArgumentException("Course with name: " + courseName + " not found.");
  }

  /**
   * method is intended to get size of the list
   * @return the amount of courses is in the list.
   */
  public int getNumberOfCourses()
  {
    return courseList.size();
  }

  /**
   * method meant to call a course by its index in the array list.
   * @param index position of the item inside the array list.
   * @return course by index.
   */
  public Course getCourse(int index)
  {
    return courseList.get(index);
  }

  /**
   * method intended to output the list of courses in a readable manner.
   * s variable is created to store all a value of all created courses.
   * In the for-loop it loops through the array list and adds each item to the s string.
   * @return s string with all created courses in a readable manner.S
   */
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