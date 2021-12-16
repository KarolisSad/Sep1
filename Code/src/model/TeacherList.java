package model;

import java.util.ArrayList;
/**
 * This class represents teacher lists, which is used to generate several teacher lists.
 *
 * @author Group 8.
 * @version 1.0 December 2021.
 */
public class TeacherList
{
  private ArrayList<Teacher> teacherList;
  /**
   * No-argument constructor.
   * In the constructor we initialize the instance variable as a new array list that will store a list of teacher.
   */
  public TeacherList()
  {
    this.teacherList = new ArrayList<>();
  }
  /**
   * method is meant to add a teacher to a teacher array list.
   * In the method a check is done, if the teacher is not already in the list.
   * If it is in the list it throws an exception.
   * @param teacher teacher that suppose to be added to the list.
   */
  public void addTeacher(Teacher teacher)
  {
    if (!(teacherList.contains(teacher)))
    {
      teacherList.add(teacher);
    }
    else
    {
      throw new IllegalArgumentException("Teacher already added");
    }
  }
  /**
   * method is meant for removing a teacher from a teacher array list.
   * @param teacher the teacher that suppose to be removed.
   */
  public void removeTeacher(Teacher teacher)
  {
    teacherList.remove(teacher);
  }
  /**
   * method is meant for removing teacher from a teacher array list by it'd teacher ID.
   * In the method, it's looped through the array list and each teacher is compared with the teacher that needs to be
   * removed, when the teacher is found it's removed and the loop breaks.
   * @param teacherID unique string that is generated for every teacher.
   */
  public void removeTeacherByID(String teacherID)
  {
    for (int i = 0; i < teacherList.size(); i++)
    {
      if (teacherList.get(i).getTeacherId().equals(teacherID))
      {
        teacherList.remove(i);
        break;
      }
    }
  }
  /**
   * method is meant to get the number of teachers in the array list.
   * @return int number of teachers in the array list.
   */
  public int size()
  {
    return teacherList.size();
  }
  /**
   * method is intended to get a teacher from an array list by its index.
   * @param index position of teacher object in an array list.
   * @return teacher object by index.
   */
  public Teacher getTeacher(int index)
  {
    return teacherList.get(index);
  }

  /**
   * method is meant to compare two teacher array lists if they are equal to each other.
   * @param obj
   * @return a boolean, true - equal, else - false.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof TeacherList))
    {
      return false;
    }
    TeacherList other = (TeacherList) obj;
    for (int i = 0; i < teacherList.size(); i++)
    {
      if (!(teacherList.get(i).equals(other.getTeacher(i))))
      {
        return false;
      }
    }
    return true;
  }
  /**
   * method meant to make a copy of a teacher list, since it has
   * a composition-relationship with several other classes.
   * In the method, it's looped through the array list adding each item to a new array list
   * in order to make an exact copy.
   * @return a copy of an original array list.
   */
  public TeacherList copy()
  {
    TeacherList other = new TeacherList();
    for (int i = 0; i < teacherList.size(); i++)
    {
      other.addTeacher(teacherList.get(i));
    }
    return other;
  }
  /**
   * method is meant to check if the teacher is part of an array list.
   * @param teacher teacher that needs to be checked against the array list.
   * @return boolean, true - if contains, else - false.
   */
  public boolean contains(Teacher teacher)
  {
    return teacherList.contains(teacher);
  }

  /**
   * method is meant to print the teacher array list in a presentable way.
   * In the method, an array list goes through few  switch-statement checks to make sure that it's not empty as well as
   * if it's only one it would have a different print out structure compared to a list of many. As a default it loops through the list and
   * adds the items one by one to a new string variable s.
   * @return teacher list in a readable manner.
   */
  public String toString()
  {
    switch (teacherList.size())
    {
      case 0:
        return "No teachers in this list";
      case 1:
        return "Teacher:\n" + teacherList.get(0);
      default:
        String s = "Teachers in list:\n";
        for (Teacher teacher : teacherList)
        {
          s += teacher + "\n";
        }
        return s;
    }

  }
}