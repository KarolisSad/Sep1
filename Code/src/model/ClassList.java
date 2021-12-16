package model;

import java.util.ArrayList;

/**
 * ClassList class is meant to store list of created classes and contains some methods so that it it would be possible to interact with them.
 * @author Group 8
 * */
public class ClassList
{
  private ArrayList<Class> classList;

  /**
   * One-argument constructor. In the constructor we initialize the instance variable as a new array list that will store a class list.
   */
  public ClassList()
  {
    classList = new ArrayList<>();
  }

  /**
   * method is meant for adding a new class to the class list.
   * @param classToAdd a class that needs to be added.
   * does not return anything as it is a void method.
   */
  public  void addClass(Class classToAdd)
  {
    classList.add(classToAdd);
  }

  /**
   * method is meant to be called to get class by its index in an array list.
   * @param index a position in an array list.
   * @return class by the index.
   */
  public Class getClassByIndex(int index)
  {
      return classList.get(index);
  }

  /**
   * method to find out list size.
   * @return how many items are in the array list.
   */
  public int size()
  {
    return classList.size();
  }

  /**
   * mehtod checks if the specified is in the array list
   * @param containsClass class that is checks if it's part of the array list.
   * @return boolean (true of false), if the class is part of the array list.
   */
  public boolean contains(Class containsClass)
  {
    return classList.contains(containsClass);
  }

  /**
   * In the method a variable s is created that has a value of all created class.
   * Loop is meant for adding all class to an array list.
   * @return s string with the list of classes that is readable.
   */
  public String toString()
  {
    String s = "Classes:\n";
    for (int i = 0; i < classList.size(); i++)
    {
      s += classList.get(i) + "\n";
    }
      return s;
  }
}
