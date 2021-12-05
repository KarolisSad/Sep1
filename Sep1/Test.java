public class test
{
  public static void main(String[] args)
  {
    TeacherList tl1 = new TeacherList();
    tl1.addTeacher(new Teacher("123", new TeacherID("123")));
    tl1.addTeacher(new Teacher("123", new TeacherID("456")));
    tl1.addTeacher(new Teacher("123", new TeacherID("789")));
    tl1.addTeacher(new Teacher("123", new TeacherID("015")));


    TeacherList tl2 = new TeacherList();
    tl2.addTeacher(new Teacher("123", new TeacherID("123")));
    tl2.addTeacher(new Teacher("123", new TeacherID("456")));
    tl2.addTeacher(new Teacher("123", new TeacherID("789")));
    tl2.addTeacher(new Teacher("123", new TeacherID("015")));

    System.out.println(tl1.equals(tl2));
  }
}
