public class courseTest
{
  public static void main(String[] args)
  {
    Course testCourse = new Course("SDJ1", 10, new Class("Y", 1), new Teacher("Steffen", new TeacherID("SVA")));

    //System.out.println(testCourse.getCourseName());

    //TEST GET COURSE STUDENT LIST

    System.out.println(testCourse.getCourseTeacherList());

    testCourse.addStudentToCourse(new Student("Student Studentson", new StudentID(1234), "X", 2));
    //System.out.println(testCourse.getCourseSize());
    //System.out.println(testCourse.getCourseStudentList());
    testCourse.removeStudentFromCourse(testCourse.getCourseStudentList().getStudent(0));
    //System.out.println(testCourse.getCourseStudentList());

    testCourse.addTeacherToCourse(new Teacher("Mona", new TeacherID("MWN")));

    System.out.println(testCourse.getCourseTeacherList());

    testCourse.removeTeacherFromCourse(testCourse.getCourseTeacherList().getTeacher(1));
  }
}
