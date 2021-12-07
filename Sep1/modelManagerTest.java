import mediator.ScheduleModelManager;

public class modelManagerTest
{
  public static void main(String[] args)
  {
    ScheduleModelManager manager = new ScheduleModelManager();

    manager.addRoom(10, "1");
    manager.addRoom(10, "2");
    manager.addRoom(10, "3");
    manager.addRoom(10, "4");
    manager.addRoom(10, "5");
    manager.addRoom(10, "6");
    // System.out.println(manager.getRoomsList());

    manager.addStudent("TestStudent1", 1, "Y", 1);
    manager.addStudent("TestStudent2", 2, "DK", 1);
    manager.addStudent("TestStudent3", 3, "X", 1);
    manager.addStudent("TestStudent4", 4, "Z", 1);
    manager.addStudent("TestStudent5", 5, "DK", 1);
    //System.out.println(manager.getStudentList());

    manager.addClass("X", 1);
    manager.addClass("Y", 1);
    manager.addClass("Z", 1);
    manager.addClass("DK", 1);
    manager.sortStudentsInClasses();
    //System.out.println(manager.getClassList());

    manager.addTeacher("Test Teacher", "TETE");
    manager.addTeacher("BOB", "BOB");
    //System.out.println(manager.getTeacherList());

    manager.addCourse("SDJ1", 10, "1Y", "BOB");
    manager.addCourse("SDJ1", 10, "1X", "BOB");
    manager.addCourse("SDJ1", 10, "1Z", "BOB");
    manager.addCourse("SDJ1", 10, "1DK", "BOB");
    //System.out.println(manager.getCourseList());

    manager.addSession("SDJ1Y", 4, 1,1,2022, 8, 30, "1");
    manager.addSession("SDJ1X", 2,1,1,2022,13,20,"2");
    System.out.println(manager.getSessionList());
  }
}
