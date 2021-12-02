import java.util.ArrayList;

public class Course
{
  private String name;
  private int ECTS;
  private Class aClass;
  private TeacherList courseTeacherList;
  private TeacherList allTeachers;
  private StudentList courseStudentList;
  private Teacher teacher;


  public Course(String name, int ECTS, Class aClass, Teacher teacher,
      TeacherList allTeachers)
  {
    if (name.equals(""))
    {
      throw new IllegalArgumentException("Course name should not be empty");
    }
    else
    {
      String courseName = "";
      courseName += name;
      courseName += aClass.getClassName();
      this.name = courseName;
    }

    if (ECTS == 5 || ECTS == 10 || ECTS == 15)
    {
      this.ECTS = ECTS;
    }
    else
    {
      throw new IllegalArgumentException("ECTS should be 5, 10 or 15");
    }

    if (aClass != null)
    {
      this.aClass = aClass;
    }
    else
    {
      throw new IllegalArgumentException("Class should not be null");
    }
    this.allTeachers = allTeachers;

    this.courseStudentList = aClass.getStudentList();
    courseTeacherList = new TeacherList();

    for (int i = 0; i < allTeachers.size(); i++)
    {
      if (allTeachers.getTeacher(i).equals(teacher))
      {
        this.teacher = teacher;
        courseTeacherList.addTeacher(teacher);
      }
    }
    courseStudentList = aClass.getStudentList();

  }

  public void setName(String name)
  {
    if (name.equals(""))
    {
      throw new IllegalArgumentException("Course name should not be empty");
    }
    else
    {
      String courseName = "";
      courseName += name;
      courseName += aClass.getClassName();
      this.name = courseName;
    }
  }

  public StudentList getStudentList()
  {
    return courseStudentList.copy();
  }

  public int numberOfStudents()
  {
    return courseStudentList.size();
  }

  public void addStudentToCourse(Student student)
  {
    courseStudentList.addStudent(student);
  }

  public void RemoveStudentFromCourse(
      Student student)
  {
    for (int i = 0; i < courseStudentList.size(); i++)
    {
      if (courseStudentList.getStudent(i).equals(student))
      {
        courseStudentList.removeStudentByIndex(i);
        break;
      }
    }
  }

  public String getName()
  {
    return name;
  }

  public void addTeacherToCourse(Teacher teacher)
  {
    for (int i = 0; i < courseTeacherList.size(); i++)
    {
      if (teacher.equals(courseTeacherList.getTeacher(i)))
      {
        throw new IllegalArgumentException("Teacher already added.");
      }
    }
    courseTeacherList.addTeacher(teacher);
  }


  //TESTING

  public String toString()
  {
   String s = "Course Name: " + name + ", ECTS-points: " + ECTS + ", number of students: " + numberOfStudents();
   if (courseTeacherList.size() > 1)
   {
     s += ", Teachers: " + courseTeacherList;
   }
   else
   {
     s += ", Teacher: " + courseTeacherList;
   }

   return s;
  }

}
