public class chrTest
{
  public static void main(String[] args)
  {
    StudentID sid1 = new StudentID(521982);
    StudentID sid2 = sid1.copy();
    //System.out.println(sid1.getIdAsString());
    //System.out.println(sid2.getIdAsString());
    TeacherID tid1 = new TeacherID("ABC");
    TeacherID tid2 = tid1.copy();
    //System.out.println(tid1.getIdAsString());
    //System.out.println(tid2.getIdAsString());
    Teacher teach1 = new Teacher("Teacher One", new TeacherID("TEACH"));
    //System.out.println(teach1.getID());
    Student student1 = new Student("StudentName", sid1, 'Y', 1);
    //System.out.println(student1);
    Teacher t1 = new Teacher("Bob Teacher", new TeacherID("BOTE"));
    Teacher t2 = new Teacher("Wendy Via", new TeacherID("WEVI"));
    TeacherList allTeachers = new TeacherList();
    allTeachers.addTeacher(t1);
    allTeachers.addTeacher(t2);
    //System.out.println(allTeachers);
    //allTeachers.removeTeacherByID("WEVI");
    //System.out.println(allTeachers);

    Student stud1 = new Student("Allan Awesome", new StudentID(12345678), 'Y', 1);
    Student stud2 = new Student("Bob Builder", new StudentID(87654321), 'Y', 1);
    Student stud3 = new Student("Chris Cross", new StudentID(45698712), 'Y', 1);
    Student stud4 = new Student("Dennis Dumb", new StudentID(78987451), 'Y', 1);
    Student stud5 = new Student("Eva Engel", new StudentID(65432198), 'X', 1);
    Student stud6 = new Student("Frank Fairy", new StudentID(55664477), 'X', 1);
    Student stud7 = new Student("George GG", new StudentID(55664477), 'X', 1);
    Student stud8 = new Student("Harry H", new StudentID(55664477), 'X', 1);
    Student stud9 = new Student("Ivan I", new StudentID(55664477), 'Z', 1);
    Student stud10 = new Student("Jacob", new StudentID(55664477), 'Z', 1);
    Student stud11= new Student("Katrine", new StudentID(55664477), 'Z', 1);
    Student stud12 = new Student("Laura", new StudentID(55664477), 'Z', 1);
    Student stud13 = new Student("Mona", new StudentID(55664477), 'D', 1);
    Student stud14 = new Student("Niels", new StudentID(55664477), 'D', 1);

    StudentList sl1 = new StudentList();
    sl1.addStudent(stud1);
    sl1.addStudent(stud2);
    sl1.addStudent(stud3);
    sl1.addStudent(stud4);
    sl1.addStudent(stud5);
    sl1.addStudent(stud6);
    sl1.addStudent(stud7);
    sl1.addStudent(stud8);
    sl1.addStudent(stud9);
    sl1.addStudent(stud10);
    sl1.addStudent(stud11);
    sl1.addStudent(stud12);
    sl1.addStudent(stud13);
    sl1.addStudent(stud14);
    //System.out.println(sl1);

    Class c1y = new Class('Y', 1, sl1);
    Class c1x = new Class('X', 1, sl1);
    Class c1z = new Class('Z', 1, sl1);
    Class c1d = new Class('D', 1, sl1);
    c1y.addStudentsToClass();
    c1x.addStudentsToClass();
    c1z.addStudentsToClass();
    c1d.addStudentsToClass();
    //System.out.println(c1y);
    //System.out.println(c1y.getStudentList());
    //System.out.println(c1x);
    //System.out.println(c1x.getStudentList());
    //System.out.println(c1z);
    //System.out.println(c1z.getStudentList());
    //System.out.println(c1d);
    //System.out.println(c1d.getStudentList());
    //c1y.removeStudentFromClass("12345678");
    //System.out.println(c1y);
    //System.out.println(c1y.getStudentList());
    Course sdj1y = new Course("SDJ1", 10,c1y, t1, allTeachers);
   // System.out.println(sdj1y);
    sdj1y.addTeacherToCourse(t2);
   // System.out.println(sdj1y);

    Room r1 = new Room(10, "102");
    DateTime dt1 = new DateTime(new Date(1,1,2021), new Time(12,25));
DateTime dt2 = new DateTime(new Date(1,1,2021), new Time(8,20));
Session s1 = new Session(sdj1y, 4, dt1, r1);
  //  System.out.println(s1);
    Session s2 = new Session(sdj1y, 4, dt2, r1);

    SessionList sel1 = new SessionList();
    sel1.add(s1);
    sel1.add(s2);

    System.out.println(sel1);






  }
}
