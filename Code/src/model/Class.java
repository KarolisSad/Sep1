package model;

/**
 * This class representing a student class.
 *
 * @author Group 8
 */
public class Class
{
  private String className;
  private StudentList cStudentList;
  private String classID;
  private int semester;

  /**
   * The two-argument constructor.
   * classNameBuilder is created with two switch statements when we input number representing the semester (1st switch) and then entering the class ID
   * as a char (2nd switch statement). The two values are put together in a String variable classNameBuilder and initialized as class name.
   * If the values for semester and classID are invalid the switch statements returns an exception.
   * @param classID when we are creating a new class we are assigning class ID (X, Y, Z or DK) to it.
   * @param semester when we are creating a new class we are assigning semester (1-7) to it.
   * In the constructor we are also creating a new array list that will contain the created classes new student list.
   */
  public Class(String classID, int semester)
  {
    this.cStudentList = new StudentList();

    String classNameBuilder = "";
    switch (semester)
    {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
        classNameBuilder += semester;
        break;
      default:
        throw new IllegalArgumentException(
            "Semester should be an integer between 1-7.");
    }

    switch (classID)
    {
      case "x":
        this.classID = "X";
        classNameBuilder += "X";
        break;
      case "y":
        this.classID = "Y";
        classNameBuilder += "Y";
        break;
      case "z":
        this.classID = "Z";
        classNameBuilder += "Z";
        break;
      case "Y":
      case "X":
      case "Z":
      case "DK":
        this.classID = classID;
        classNameBuilder += classID;
        break;
      default:
        throw new IllegalArgumentException(
            "ClassID should be one of the following: X, Y, Z or DK");
    }

    this.className = classNameBuilder;

    this.semester = semester;
  }

  /**
   *Meant to call a class name.
   * @return class name as a string.
   */
  public String getClassName()
  {
    return className;
  }

  /**
   * calls a specified student list
   * @return a copy of all students enrolled into the class the method is called on.
   */
  public StudentList getClassStudentList()
  {
    return cStudentList.copy();
  }

  /**
   * calls semester.
   * @return semester as an int.
   */
  public int getSemester()
  {
    return semester;
  }

  /**
   * calls classID.
   * @return class ID as a char.
   */
  public String getClassID()
  {
    return classID;
  }

  /**
   * calls student list of a specific class.
   * @return the number of students that are stored in that class.
   */
  public int getNumberOfStudents()
  {
    return cStudentList.size();
  }


  /**
   * calls student list so that the new student would be added to the existing list.
   * It's a void method, therefore it does not return anything.
   * @param student
   */
  public void addStudentToClass(Student student)
  {
    cStudentList.addStudent(student);
  }

  //It may be deleted
  public void removeStudentFromClass(Student student)
  {
    cStudentList.removeStudent(student);
  }

  /**
   * Calls student list so that the student would be removed from the existing list with that student name.
   * It loops through all students in the specified list and compares the given studentID that needs to be removed with the ones stored in the list.
   * If entered studentID is the correct, it is removed from the list and the loop is broken. Otherwise, it will through an exception.
   * It's a void method, therefore it does not return anything.
   * @param studentID
   */
  public void removeStudentFromClass(String studentID)
  {
    for (int i = 0; i < cStudentList.size(); i++)
    {
      if (cStudentList.getStudent(i).getStudentId().equals(studentID))
      {
        cStudentList.removeStudentByIndex(i);
        break;
      }
      else
        throw new IllegalArgumentException("Student not found");
    }
  }

  /**
   * method creates a string variable that contains class name.
   * @return s variable with information about the class.
   */
  public String toString()
  {
    String s = "Class: " + getClassName();


    return s;
  }

  /**
   * method is meant to check if the specified student is in the specified list of students.
   * @param student takes a student object
   * @return a boolean (true of false) if the student is part of the list.
   */
  public boolean contains(Student student)
  {
    return cStudentList.contains(student);
  }

  /**
   * method is meant to compare two Class objects if they are equal to each other.
   * @param obj
   * @return a boolean (true of false) if the objects are same or not.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Class))
    {
      return false;
    }
    Class other = (Class) obj;
    return className == other.className && cStudentList.equals(
        other.cStudentList);
  }

}