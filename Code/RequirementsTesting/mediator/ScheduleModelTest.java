package mediator;
/*
import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleModelTest
{
  ScheduleModel model = new ScheduleModelManager();

  // Manage Courses

  @Test void addCourse()
  {
    model.addTeacher("Wendy Worker", "WWO");
    model.addClass("Y", 1);
    model.addCourse("SDJ", 10, "1Y", "WWO");
    assertEquals("SDJ1Y", model.getCourse(0).getCourseName());
  }


  @Test void getCourseStudentList()
  {
    model.addClass("Y", 1);
    model.addStudent("Student1", 1, "Y", 1);
    model.addStudent("Student1", 2, "Y", 1);
    model.addStudent("Student1", 3, "Y", 1);
    model.addStudent("Student1", 4, "Y", 1);
    model.addStudent("Student1", 5, "Y", 1);
    model.sortStudentsInClasses();
    model.addTeacher("Steffen Vissing Andersen", "SVA");
    model.addCourse("SDJ", 10, "1Y", "SVA");
    assertEquals(5,
        model.getCourseStudentList(model.getCourseByName("SDJ1Y")).size());
  }

  @Test void getCourseSize()
  {
    model.addTeacher("Steffen Vissing Andersen", "SVA");
    model.addClass("Y", 2);
    model.addCourse("SDJ", 10, "2Y", "SVA");
    model.addTeacher("Richard Brooks", "RIB");
    model.addClass("Y", 1);
    model.addCourse("DMA", 10, "2Y", "RIB");

    assertEquals(2, model.getCourseSize());
  }

  @Test void getCourse()
  {
    model.addTeacher("Wendy Worker", "WWO");
    model.addClass("Y", 1);
    model.addCourse("SDJ", 10, "1Y", "WWO");
    assertEquals(
        "Course: SDJ1Y, Number of students: 0, Teacher:\nName: Wendy Worker, Teacher ID: WWO\n",
        model.getCourse(0).toString());
  }

  @Test void getCourseByName()
  {
    model.addTeacher("Wendy Worker", "WWO");
    model.addClass("Y", 1);
    model.addCourse("SDJ", 10, "1Y", "WWO");
    assertEquals("Wendy Worker",
        model.getCourseByName("SDJ1Y").getCourseTeacherList().getTeacher(0)
            .getName());
  }

  @Test void removeCourse()
  {
    model.addTeacher("Steffen Vissing Andersen", "SVA");
    model.addClass("Y", 2);
    model.addCourse("SDJ", 10, "2Y", "SVA");
    model.addTeacher("Richard Brooks", "RIB");
    model.addClass("Y", 1);
    model.addCourse("DMA", 10, "2Y", "RIB");
    model.removeCourseBy("DMA");

    assertEquals(1, model.getCourseSize());
  }

  @Test void removeCourseBy()
  {
  }

  @Test void addStudentToCourse()
  {
  }

  @Test void removeStudentFromCourse()
  {
  }

  // Manage Students
  @Test void addStudent()
  {
    model.addStudent("Bob Builder", 123456, "DK", 3);
    assertEquals("Bob Builder 123456 3DK",
        model.getStudent(0).getName() + " " + model.getStudent(0).getStudentId()
            + " " + model.getStudent(0).getClassName());
  }

  @Test void studentListSize()
  {
    model.addStudent("Student1", 1, "Y", 1);
    model.addStudent("Student1", 2, "Y", 1);
    model.addStudent("Student1", 3, "Y", 1);
    model.addStudent("Student1", 4, "Y", 1);
    model.addStudent("Student1", 5, "Y", 1);
    assertEquals(5, model.studentListSize());
  }

  @Test void getStudent()
  {
    model.addStudent("Bob Builder", 123456, "DK", 3);
    assertEquals("Bob Builder 123456 3DK",
        model.getStudent(0).getName() + " " + model.getStudent(0).getStudentId()
            + " " + model.getStudent(0).getClassName());
  }

  @Test void sortStudentsInClasses()
  {
    model.addClass("Y", 1);
    model.addClass("X", 1);
    model.addStudent("Student1", 2, "Y", 1);
    model.addStudent("Student1", 3, "Y", 1);
    model.addStudent("Student1", 4, "X", 1);
    model.addStudent("Student1", 5, "X", 1);
    model.sortStudentsInClasses();
    assertEquals("2 + 2",
        model.getClass(0).getNumberOfStudents() + " + " + model.getClass(1)
            .getNumberOfStudents());
  }

  @Test void removeStudent()
  {
    model.addClass("Y", 1);
    model.addClass("X", 1);
    model.addStudent("Student1", 2, "Y", 1);
    model.addStudent("Student1", 3, "Y", 1);
    model.addStudent("Student1", 4, "X", 1);
    model.addStudent("Student1", 5, "X", 1);
    model.sortStudentsInClasses();
    model.removeStudent(model.getStudent(3));
    assertEquals("2 + 1",
        model.getClass(0).getNumberOfStudents() + " + " + model.getClass(1)
            .getNumberOfStudents());
  }

  @Test void removeStudentFromVIA()
  {
  }

  // Manage Classes

  @Test void addClass()
  {
    model.addClass("DK", 3);
    assertEquals("3DK", model.getClass(0).getClassName());
  }

  @Test void testGetClass()
  {
    model.addClass("Y", 3);
    assertEquals("3Y", model.getClass(0).getClassName());
  }

  @Test void getClassListSize()
  {
    model.addClass("Y", 1);
    model.addClass("X", 2);
    model.addClass("Z", 3);
    model.addClass("DK", 4);
    assertEquals(4, model.getClassListSize());
  }

  // Manage Teachers

  @Test void addTeacher()
  {
    model.addTeacher("Wendy Worker", "WWO");
    assertEquals("Wendy Worker", model.getTeacher(0).getName());
  }

  @Test void getTeacher()
  {
    model.addTeacher("Wendy Worker", "WWO");
    assertEquals("Wendy Worker", model.getTeacher(0).getName());
  }

  @Test void getTeacherSize()
  {
    model.addTeacher("Wendy Worker", "WWO");
    model.addTeacher("Steffen Vissing Andersen", "SVA");
    model.addTeacher("Richard Brooks", "RIB");
    assertEquals(3, model.getTeacherSize());
  }

  @Test void removeTeacher()
  {
  }

  // Manage Sessions

  @Test void addSession()
  {
    model.addRoom(20, "101");
    model.addTeacher("Wendy Worker", "WWO");
    model.addClass("Y", 1);
    model.addCourse("SDJ", 10, "1Y", "WWO");
    model.addSession("SDJ1Y", 4, 3, 1, 2022, 8, 20, "101");
    assertEquals("820",
        model.getSession(0).getStartDateTime().getTime().getHour() + "" + ""
            + model.getSession(0).getStartDateTime().getTime().getMinute());
  }

  @Test void sessionListSize()
  {
    model.addRoom(20, "101");
    model.addTeacher("Wendy Worker", "WWO");
    model.addClass("Y", 1);
    model.addCourse("SDJ", 10, "1Y", "WWO");
    model.addSession("SDJ1Y", 4, 3, 1, 2022, 8, 20, "101");
    model.addSession("SDJ1Y", 4, 4, 1, 2022, 8, 20, "101");
    model.addSession("SDJ1Y", 4, 5, 1, 2022, 8, 20, "101");
    assertEquals(3, model.sessionListSize());

  }

  @Test void getSession()
  {
    model.addRoom(20, "101");
    model.addTeacher("Wendy Worker", "WWO");
    model.addClass("Y", 1);
    model.addCourse("SDJ", 10, "1Y", "WWO");
    model.addSession("SDJ1Y", 4, 3, 1, 2022, 8, 20, "101");
    assertEquals("SDJ1Y", model.getSession(0).getCourse().getCourseName());
  }

  @Test void removeSessionBy()
  {
  }















}
 */
