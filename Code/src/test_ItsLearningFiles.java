import mediator.ScheduleModelManager;

public class test_ItsLearningFiles
{
  public static void main(String[] args)
  {
    ScheduleModelManager manager = new ScheduleModelManager();

    manager.addRoom(45, "C05.15");
    manager.addRoom(45, "C05.16a");
    manager.addRoom(45, "C05.16b");
    manager.addRoom(20, "C03.12");
    manager.addRoom(125, "C03.13");
    //System.out.println(manager.getRoomsList());

    manager.addStudent("Abraham Jackson", 667345, "X", 1);
    manager.addStudent("Brian Nielsen", 667346, "X", 1);
    manager.addStudent("Christina Lana", 667347, "Y", 1);
    manager.addStudent("Dennis Kolin", 667465, "Y", 1);
    manager.addStudent("Eric Lynn", 667469, "y", 1);
    manager.addStudent("Franck Thomson", 667554, "Y", 1);
    manager.addStudent("Gregor Gori", 667555, "Y", 1);
    manager.addStudent("Helly Hansen", 667556, "Z", 1);
    manager.addStudent("Ion Brick", 667578, "Z", 1);
    manager.addStudent("Julia Schwartz", 667590, "Z", 1);
    //System.out.println(manager.getStudentList());

    manager.addClass("X", 1);
    manager.addClass("Y", 1);
    manager.addClass("Z", 1);
    manager.addClass("DK", 1);
    manager.addClass("X", 2);
    manager.sortStudentsInClasses();
    //System.out.println(manager.getClassList());

    manager.addTeacher("Alhe", "ALHE");
    manager.addTeacher("Steffen", "SVA");
    manager.addTeacher("Klaus", "KLAB");
    manager.addTeacher("Mivi", "MIVI");
    manager.addTeacher("Kasper", "KASR");
    manager.addTeacher("Line", "LILE");
    manager.addTeacher("Allan", "AHAN");
    manager.addTeacher("Richard Brooks", "RIB");
    manager.addTeacher("Io", "IOOD");
    manager.addTeacher("Mona", "MWA");
    manager.addTeacher("Hektor", "HEKP");
    manager.addTeacher("Thomas", "TRMO");

    manager.addCourse("SDJ1", 10, "1X", "ALHE");
    manager.addCourse("SDJ1", 10, "1Y", "SVA");
    manager.addCourse("SDJ1", 10, "1Z", "SVA");
    manager.getCourseList().getCourseByName("SDJ1Z")
        .addTeacherToCourse(manager.getTeacherByID("KLAB"));
    manager.addCourse("SDJ1", 10, "1DK", "MIVI");
    manager.addCourse("RWD1", 5, "1X", "KASR");
    manager.addCourse("RWD1", 5, "1Y", "LILE");
    manager.addCourse("RWD1", 5, "1Z", "LILE");
    manager.addCourse("RWD1", 5, "1DK", "AHAN");
    manager.addCourse("DMA1", 5, "1Y", "RIB");
    manager.addCourse("DMA1", 5, "1X", "RIB");
    manager.addCourse("DMA1", 5, "1Z", "IOOD");
    manager.addCourse("DMA1", 5, "1DK", "IOOD");
    manager.addCourse("SEP1", 10, "1X", "ALHE");
    manager.getCourseList().getCourseByName("SEP1X")
        .addTeacherToCourse(manager.getTeacherByID("MWA"));
    manager.addCourse("SEP1", 10, "1Y", "SVA");
    manager.getCourseList().getCourseByName("SEP1Y")
        .addTeacherToCourse(manager.getTeacherByID("MWA"));
    manager.addCourse("SEP1", 10, "1Z", "SVA");
    manager.getCourseList().getCourseByName("SEP1Z")
        .addTeacherToCourse(manager.getTeacherByID("MWA"));
    manager.addCourse("SEP1", 10, "1DK", "MIVI");
    manager.getCourseList().getCourseByName("SEP1DK")
        .addTeacherToCourse(manager.getTeacherByID("AHAN"));
    manager.addCourse("SEP2", 10, "2X", "HEKP");
    manager.getCourseList().getCourseByName("SEP2X")
        .addTeacherToCourse(manager.getTeacherByID("TRMO"));
    //System.out.println(manager.getCourseList());


    manager.addSession("SDJ1X", 4, 8,12,2021,8,20,"C05.16a");
    manager.addSession("SDJ1Y", 4, 8,12,2021,8,20,"C05.16b");
    manager.addSession("SDJ1Z", 4, 9,12,2021,8,20,"C05.16a");
    manager.addSession("SDJ1DK", 4, 9,12,2021,8,20,"C03.12");
    manager.addSession("SDJ1Y", 2, 8, 12, 2021, 13, 20, "C05.15");
    manager.addSession("SEP1Y", 3, 9, 12, 2021, 14, 40, "C05.16b");

   manager.createSessionListXML();

  }
}
