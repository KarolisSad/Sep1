public class test
{
  public static void main(String[] args)
  {
    //      Creating Teachers, TeacherList - and adding teachers to list      //
    Teacher t1 = new Teacher("Bob Teacher", new TeacherID("BOTE"));
    Teacher t2 = new Teacher("Wendy Via", new TeacherID("WEVI"));
    Teacher t3 = new Teacher("Teacher 3", new TeacherID("TE3"));
    Teacher t4 = new Teacher("Teacher 4", new TeacherID("TE4"));
    Teacher t5 = new Teacher("Teacher 5", new TeacherID("TE5"));
    Teacher t6 = new Teacher("Teacher 6", new TeacherID("TE6"));
    Teacher t7 = new Teacher("Teacher 7", new TeacherID("TE7"));
    Teacher t8 = new Teacher("Teacher 8", new TeacherID("TE8"));
    Teacher t9 = new Teacher("Teacher 9", new TeacherID("TE9"));

    TeacherList allTeachers = new TeacherList();
    allTeachers.addTeacher(t1);
    allTeachers.addTeacher(t2);
    allTeachers.addTeacher(t3);
    allTeachers.addTeacher(t4);
    allTeachers.addTeacher(t5);
    allTeachers.addTeacher(t6);
    allTeachers.addTeacher(t7);
    allTeachers.addTeacher(t8);
    allTeachers.addTeacher(t9);
    //      Testing     //
      /*{
        System.out.println(allTeachers);
        allTeachers.removeTeacherByID("WEVI");
        System.out.println(allTeachers);
      }

       */

    //      Creating Students, studentList and adding     //
    Student stud1 = new Student("Allan Awesome", new StudentID(12345678), 'Y',
        1);
    Student stud2 = new Student("Bob Builder", new StudentID(87654321), 'Y', 1);
    Student stud3 = new Student("Chris Cross", new StudentID(45698712), 'Y', 1);
    Student stud4 = new Student("Dennis Dumb", new StudentID(78987451), 'Y', 1);
    Student stud5 = new Student("Eva Engel", new StudentID(65432198), 'X', 1);
    Student stud6 = new Student("Frank Fairy", new StudentID(55664477), 'X', 1);
    Student stud7 = new Student("George GG", new StudentID(55664477), 'X', 1);
    Student stud8 = new Student("Harry H", new StudentID(55664477), 'X', 1);
    Student stud9 = new Student("Ivan I", new StudentID(55664477), 'Z', 1);
    Student stud10 = new Student("Jacob", new StudentID(55664477), 'Z', 1);
    Student stud11 = new Student("Katrine", new StudentID(55664477), 'Z', 1);
    Student stud12 = new Student("Laura", new StudentID(55664477), 'Z', 1);
    Student stud13 = new Student("Mona", new StudentID(55664477), 'D', 1);
    Student stud14 = new Student("Niels", new StudentID(55664477), 'D', 1);

    StudentList allStudents = new StudentList();
    {
      allStudents.addStudent(stud1);
      allStudents.addStudent(stud2);
      allStudents.addStudent(stud3);
      allStudents.addStudent(stud4);
      allStudents.addStudent(stud5);
      allStudents.addStudent(stud6);
      allStudents.addStudent(stud7);
      allStudents.addStudent(stud8);
      allStudents.addStudent(stud9);
      allStudents.addStudent(stud10);
      allStudents.addStudent(stud11);
      allStudents.addStudent(stud12);
      allStudents.addStudent(stud13);
      allStudents.addStudent(stud14);
    }
    //      Testing     //

      /*{
        System.out.println(allStudents);
      }
       */

    //      Creating Classes and adding students to these     //
    Class c1y = new Class('Y', 1, allStudents);
    Class c1x = new Class('X', 1, allStudents);
    Class c1z = new Class('Z', 1, allStudents);
    Class c1d = new Class('D', 1, allStudents);
    c1y.addStudentsToClass();
    c1x.addStudentsToClass();
    c1z.addStudentsToClass();
    c1d.addStudentsToClass();

    //      Testing     //
   /* {
      System.out.println(c1y);
      System.out.println(c1y.getStudentList());
      System.out.println(c1x);
      System.out.println(c1x.getStudentList());
      System.out.println(c1z);
      System.out.println(c1z.getStudentList());
      System.out.println(c1d);
      System.out.println(c1d.getStudentList());
      c1y.removeStudentFromClass("12345678");
      System.out.println(c1y);
      System.out.println(c1y.getStudentList());
    }
    */

    //      Creating Courses      //
    Course sdj1y = new Course("SDJ1", 10, c1y, t1, allTeachers);
    Course dma1y = new Course("DMA1", 10, c1y, t2, allTeachers);
    Course sep1y = new Course("SEP1", 10, c1y, t3, allTeachers);
    Course sdj1x = new Course("SDJ1", 10, c1x, t4, allTeachers);
    Course dma1x = new Course("DMA1", 10, c1x, t5, allTeachers);
    Course sep1x = new Course("SEP1", 10, c1z, t6, allTeachers);
    Course sdj1z = new Course("SDJ1", 10, c1z, t7, allTeachers);
    Course dma1z = new Course("DMA1", 10, c1z, t8, allTeachers);
    Course sep1z = new Course("SEP1", 10, c1z, t9, allTeachers);

    //      Creating Rooms      //
    Room r1 = new Room(20, "B1.01");
    Room r2 = new Room(20, "B1.02");
    Room r3 = new Room(20, "B1.03");
    Room r4 = new Room(20, "B1.04");
    Room r5 = new Room(20, "B1.05");
    Room r6 = new Room(20, "B1.06");
    Room containTest = new Room(100, "TEST");

    //      Creating RoomList     //
    SessionList sessionList = new SessionList();
    RoomList allRooms = new RoomList(sessionList);
    RoomList availableRooms = new RoomList(sessionList);

    allRooms.addRoom(r1);
    allRooms.addRoom(r2);
    allRooms.addRoom(r3);
    allRooms.addRoom(r4);
    allRooms.addRoom(r5);
    allRooms.addRoom(r6);

    //      TEST      //
/*
    System.out.println(allRooms);
  System.out.println(allRooms.contains(containTest));

 */
    // Creating DateTime      // - Should we make Time final maybe??
    DateTime dt1 = new DateTime(new Date(1, 1, 2021), new Time(8, 20));
    DateTime dt2 = new DateTime(new Date(1, 1, 2021), new Time(9, 20));
    DateTime dt3 = new DateTime(new Date(1, 1, 2021), new Time(10, 20));
    DateTime dt4 = new DateTime(new Date(1, 1, 2021), new Time(11, 20));
    DateTime dt5 = new DateTime(new Date(1, 1, 2021), new Time(13, 20));
    DateTime dt6 = new DateTime(new Date(1, 1, 2021), new Time(14, 20));
    DateTime dt7 = new DateTime(new Date(1, 1, 2021), new Time(15, 20));
    DateTime dt8 = new DateTime(new Date(1, 1, 2021), new Time(16, 20));
    DateTime dt9 = new DateTime(new Date(1, 1, 2021), new Time(17, 20));

    //      Create Sessions     //
    Session session1 = new Session(sdj1y, 4,dt1,r1, allRooms);
    allRooms.getSessionList().addSession(session1);
    //allRooms.getSessionList().addSession(new Session(dma1y, 4, dt2, r2, allRooms)); //THROWS EXCEPTION :-)
    allRooms.getSessionList().addSession(new Session(dma1y, 4, dt5, r2, allRooms)); // adds fine :-)
    System.out.println(allRooms.getSessionList());




  }
}
