package file;

import mediator.*;
import model.*;
import model.Class;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class handling the import and export to and from external files
 */
public class ScheduleFile
{
  /**
   * Static method importing students from a .txt file
   * @return studentlist containing the students imported.
   */
  public static StudentList importStudents()
  {
    File file = new File("Student.txt");
    StudentList studentList = new StudentList();
    try
    {
      Scanner in = new Scanner(file);
      while (in.hasNext())
      {
        String line = in.nextLine();
        String[] token = line.split(",");
        int semester = Integer.parseInt(token[0].trim());
        String mainClass = token[1].trim();
        String name = token[2].trim();
        int studentID = Integer.parseInt(token[3].trim());
        studentList.addStudent(new Student (name,new StudentID(studentID),mainClass,semester));
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Students file not found - no students imported.");
      //e.printStackTrace();
    }
    return studentList;

  }
  /**
   * Static method importing classes from a .txt file
   * @return classList containing the classes imported.
   */
  public static ClassList importClasses()
  {
    File file = new File("Classes.txt");
    ClassList classList = new ClassList();
    try
    {
      Scanner in = new Scanner(file);
      while (in.hasNext())
      {
        String line = in.nextLine();
        String[] token = line.split(",");
        String mainClass = token[0].trim();
        int semester = Integer.parseInt(token[1].trim());
        classList.addClass(new model.Class(mainClass,semester));
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Classes file not found - no classes imported.");
      //e.printStackTrace();
    }
    return classList;

  }
  /**
   * Static method importing teachers from a .txt file
   * @return teacherList containing the teachers imported.
   */
  public static TeacherList importTeachers()
  {
    File file = new File("Teachers.txt");
    TeacherList teacherList = new TeacherList();
    try
    {
      Scanner in = new Scanner(file);
      while (in.hasNext())
      {
        String line = in.nextLine();
        String[] token = line.split(",");
        String name = token[0].trim();
        String id = token[1].trim();
        teacherList.addTeacher(new Teacher(name,new TeacherID(id)));

      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Teacher file not found - no teachers imported.");
     // e.printStackTrace();
    }
    return teacherList;

  }
  /**
   * Static method importing rooms from a .txt file
   * @return roomList containing the rooms imported.
   */
  public static RoomList importRooms()
  {
    File file = new File("Rooms.txt");
    RoomList roomList = new RoomList();
    try
    {
      Scanner in = new Scanner(file);
      while (in.hasNext())
      {
        String line = in.nextLine();
        String[] token = line.split(",");
        String name = token[0].trim();
        int capacity = Integer.parseInt(token[1].trim());
        roomList.addRoom(new Room(capacity,name));



      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Rooms file not found - no rooms imported.");
     // e.printStackTrace();
    }
    return roomList;

  }
  /**
   * Static method importing courses from a .txt file
   * @return courseList containing the courses imported.
   */
  public static CourseList importCourses()
  {
    File file = new File("Courses.txt");
    CourseList courseList = new CourseList();
    try
    {
      Scanner in = new Scanner(file);
      while (in.hasNext())
      {
        String line = in.nextLine();
        String[] token = line.split(",");
        int semester = Integer.parseInt(token[0].trim());
        String classLetter = token[1].trim();
        String courseName = token[2].trim();
        String teacherId = token[3].trim();
        int ects = Integer.parseInt(token[4].trim());

        courseList.addCourse(new Course(courseName,ects, new model.Class(classLetter,semester),new Teacher(teacherId,new TeacherID(teacherId))));



      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Courses file not found - no courses imported.");
      //e.printStackTrace();
    }
    return courseList ;

  }

  /**
   * Static method importing sessions from a .txt file
   * @return SessionList containing the sessions imported.
   */
  public static SessionList importSessions()
  {
    File file = new File("sessions.txt");
    SessionList sessionList = new SessionList();
    try
    {
      Scanner in = new Scanner(file);
      while (in.hasNext())
      {
        String line = in.nextLine();
        String[] token = line.split(",");
        String courseName = token[0].trim();
        int length = Integer.parseInt(token[1].trim());
        int day = Integer.parseInt(token[2].trim());
        int month = Integer.parseInt(token[3].trim());
        int year = Integer.parseInt(token[4].trim());
        int hour = Integer.parseInt(token[5].trim());
        int minute = Integer.parseInt(token[6].trim());
        String roomNumber = token[7].trim();
        int capacity = Integer.parseInt(token[8].trim());
        int ects = Integer.parseInt(token[9].trim());
        String classID = token[10].trim();
        int semester = Integer.parseInt(token[11].trim());
        String teacherName = token[12].trim();
        String teacherID = token[13].trim();


        sessionList.addSession(new Session(new Course(courseName,ects, new Class(classID,semester),new Teacher(teacherName,new TeacherID(teacherID))), length, new DateTime(new Date(day,month,year),new Time(hour, minute)),new Room(capacity,roomNumber)));
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Session file not found - no sessions imported.");
     // e.printStackTrace();
    }
    return sessionList ;
  }
  /**
   * Static method exporting a SessionList to .XML
   * @return .XML file containing the SessionList with all information: Course, Students, Teacher etc..
   */
  public static void toXML(Object obj, String filename)
  {
    XmlJsonParser xmlparser = new XmlJsonParser();
    File file = null;

    try
    {
      file = xmlparser.toXml(obj, filename);
    }
    catch (ParserException parserE)
    {
      parserE.printStackTrace();
    }

    System.out.println("XML Location: " + file.getAbsolutePath());
  }
}
