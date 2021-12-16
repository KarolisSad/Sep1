package model;

import java.util.ArrayList;
/**
 * This class represents student lists, which is used to generate several student lists.
 *
 * @author Group 8.
 * @version 1.0 December 2021.
 */
public class StudentList
{
  private ArrayList<Student> studentList;
  /**
   * No-argument constructor.
   * In the constructor we initialize the instance variable as a new array list that will store a list of students.
   */
  public StudentList()
  {
    this.studentList = new ArrayList<>();
  }
  /**
   * method meant for adding students to a student array list.
   * @param student the student that suppose to be added.
   */
  public void addStudent(Student student)
  {
    studentList.add(student);
  }
  /**
   * method is meant for removing students from a student array list.
   * In the method the specified student goes through a check if it's part of the student array list,
   * that the student needs to be removed from, otherwise it will throw an exception.
   * @param student the student that suppose to be removed.
   */
  public void removeStudent(Student student)
  {
    if (studentList.contains(student))
    {
      studentList.remove(student);
    }
    else
    {
      throw new IllegalArgumentException("Student not in selected list: ");
    }
  }
  /**
   * method is meant for removing student from a student array list by it'd index.
   * @param index the position of the item in an array list.
   */
  public void removeStudentByIndex(int index)
  {
    studentList.remove(index);
  }
  /**
   * method is meant for removing student from a student array list by it'd student ID.
   * In the method, it's looped through the array list and each student is compared with the student that needs to be
   * removed, when the student is found it's removed and the loop breaks, otherwise it will through an exception.
   * @param studentID unique number that is generated for every student.
   */
  public void removeStudentByID(String studentID)
  {
    for (int i = 0; i < studentList.size(); i++)
    {
      if (studentList.get(i).getStudentId().equals(studentID))
      {
        studentList.remove(i);
        break;
      }
    }
     throw new IllegalArgumentException("Student not found");
  }
  /**
   * method is meant to get a number of item stored in the array list.
   * @return int of number of students in the array list.
   */
  public int size()
  {
    return studentList.size();
  }
  /**
   * method is meant to get a student from an array list by index.
   * @param index the position of the item in an array list.
   * @return student object from the array list.
   */
  public Student getStudent(int index)
  {
    return studentList.get(index);
  }

  /**
   * method meant to make a copy of a student list, since it has
   * a composition-relationship with several other classes.
   * In the method, it's looped through the array list adding each item to a new array list
   * in order to make an exact copy.
   * @return a copy of an original array list.
   */
  public StudentList copy()
  {
    StudentList other = new StudentList();
    for (int i = 0; i < studentList.size(); i++)
    {
      other.addStudent(studentList.get(i));
    }
    return other;
  }
  /**
   * mehtod is meant to check if student belongs to an array list.
   * @param student the student that needs to be checked against students in an array list.
   * @return boolean, true - if contains, false - if does not.
   */
  public boolean contains(Student student)
  {
    return studentList.contains(student);
  }

  // TESTING
  /**
   * method is meant to make a presentable list of students.
   * In the method, it's looped through an array list and one by one each item is added to a new created string variable s.
   * @return s string that contains presentable list of students.
   */
  public String toString()
  {
    String s = "Students in list:\n";
    for (int i = 0; i < studentList.size(); i++)
    {
      s += studentList.get(i) + "\n";
    }
    return s;
  }


  public boolean containsById(int id)
  {
    for (int i = 0;i< studentList.size();i++)
    {
      if (Integer.parseInt(studentList.get(i).getStudentId()) == id)
      {
        return false;
      }
    }
    return true;
  }
}

