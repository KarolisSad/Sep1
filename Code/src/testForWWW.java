import mediator.ScheduleModelManager;

public class testForWWW
{
  public static void main(String[] args)
  {
    ScheduleModelManager SMM = new ScheduleModelManager();
    //Rooms
    {
      SMM.addRoom(5, "A1.01");
      SMM.addRoom(5, "A1.02");
      SMM.addRoom(5, "A1.03");
      SMM.addRoom(5, "A2.01");
      SMM.addRoom(5, "A2.02");
      SMM.addRoom(5, "A2.03");
      SMM.addRoom(5, "B1.01");
      SMM.addRoom(5, "B1.02");
      SMM.addRoom(5, "B1.03");
      SMM.addRoom(5, "B2.01");
      SMM.addRoom(5, "B2.02");
      SMM.addRoom(5, "B2.03");
      SMM.addRoom(5, "C1.01");
      SMM.addRoom(5, "C1.02");
      SMM.addRoom(5, "C1.03");
      SMM.addRoom(5, "C2.01");
      SMM.addRoom(5, "C2.02");
      SMM.addRoom(5, "C2.03");
    }
    //Students
    {
      //1x
      SMM.addStudent("Allan", 1111, "X", 1);
      SMM.addStudent("Bertil", 1112, "X", 1);
      SMM.addStudent("Christian", 1113, "X", 1);
      SMM.addStudent("Daniel", 1114, "X", 1);
      //1y
      SMM.addStudent("Allan", 1121, "Y", 1);
      SMM.addStudent("Bertil", 1122, "Y", 1);
      SMM.addStudent("Christian", 1123, "Y", 1);
      SMM.addStudent("Daniel", 1124, "Y", 1);
      //1DK
      SMM.addStudent("Allan", 1131, "DK", 1);
      SMM.addStudent("Bertil", 1132, "DK", 1);
      SMM.addStudent("Christian", 1133, "DK", 1);
      SMM.addStudent("Daniel", 1134, "DK", 1);
    }
    //Classes
    {
      SMM.addClass("X", 1);
      SMM.addClass("Y", 1);
      SMM.addClass("DK", 1);
    }
    SMM.sortStudentsInClasses();
    //Teachers
    {
      SMM.addTeacher("Steffen Vissing Andersen", "SVA");
      SMM.addTeacher("Mona Wendel Andersen", "MWA");
      SMM.addTeacher("Line Lindhardt Egsgaard", "LILE");
      SMM.addTeacher("Richard Brooks", "RIB");
    }
    //Courses
    {
      SMM.addCourse("SDJ1", 10, "1X", "SVA");
      SMM.getCourseList().getCourseByName("SDJ1X").addTeacherToCourse(
          SMM.getTeacherByID("RIB"));
      SMM.addCourse("SDJ1", 10, "1Y", "SVA");
      SMM.addCourse("SDJ1", 10, "1DK", "SVA");
      SMM.addCourse("SEP1", 10, "1X", "MWA");
      SMM.addCourse("SEP1", 10, "1Y", "MWA");
      SMM.addCourse("SEP1", 10, "1DK", "MWA");
      SMM.addCourse("RWD1", 5, "1X", "LILE");
      SMM.addCourse("RWD1", 5, "1Y", "LILE");
      SMM.addCourse("RWD1", 5, "1DK", "LILE");
    }
    //Sessions
    {
      SMM.addSession("SDJ1X", 4, 3, 1, 2022, 8,20,"A1.01");
      SMM.addSession("RWD1X", 2, 3, 1, 2022, 12,45,"A1.01");
     SMM.addSession("SEP1X", 4, 4, 1, 2022, 8,20,"A1.01");
      SMM.addSession("SDJ1Y", 4, 7, 1, 2022, 8,20,"B1.01");
      SMM.addSession("RWD1Y", 2, 4, 1, 2022, 12,45,"B1.01");
      SMM.addSession("SEP1Y", 4, 5, 1, 2022, 8,20,"B1.01");
     SMM.addSession("SDJ1DK", 4, 7, 1, 2022, 12,45,"C1.01");
      SMM.addSession("RWD1DK", 2, 5, 1, 2022, 12,45,"C1.01");
      SMM.addSession("SEP1DK", 4, 6, 1, 2022, 8,20,"C1.01");
      SMM.addSession("SEP1X", 4, 10, 1, 2022, 8,20,"A1.01");
    }
    SMM.createSessionListXML();


  }
}
