import java.security.PublicKey;
import java.util.ArrayList;

public class Course
{
  private String name;
  private int ECTS;
  private Class class;
  private TeacherList teacherList;
  private StudentList studentList;

  public Course (String name, int ECTS, Class class, TeacherList teacherList, StudentList studentList)
  {
    this.name = name;
    this.ECTS = ECTS;
    this.class = class;
    this.teacherList = teacherList;
    this.studentList = class.getStudentList();
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public StudentList getStudentList(char className)
  {
    return studentList.copy();
  }

  public void addStudentToCourse (Student student)
  {
    studentList.add(student);
  }

  public void RemoveStudentFromCourse (Student student)
  {
    studentList.remove(student);
  }

  public TeacherList getTeacherList()
  {
    return teacherList.copy();
  }

  public void addTeacherToCourse ()
  {
    teacher.add
  }

}
