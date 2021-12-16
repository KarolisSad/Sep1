package model;

import java.util.ArrayList;

/**
 * Class that contains an array list of sessions created as well as a few methods that can interact with the list.
 * @author Group 8
 */
public class SessionList
{
  private ArrayList<Session> sessionList;
  /**
   * One-argument constructor. In the constructor we initialize the instance variable as a new array list that will store a list of sessions.
   */
  public SessionList()
  {
    this.sessionList = new ArrayList<>();
  }
  /**
   * method is meant for adding a new session to the session list.
   * @param session a session object that needs to be added.
   * does not return anything as it is a void method.
   */
  public void addSession(Session session)
  {
    sessionList.add(session);
  }

  // do we need it?

  /**
   * method is meant for removing a session from the session array list by index.
   * @param index position of the specified session.
   */
  public void removeSessionByIndex(int index)
  {
    sessionList.remove(index);
  }
  // do we need it?


  public void removeSession(Session session)
  {
    if (sessionList.contains(session))
    {
      sessionList.remove(session);
    }
    else
    {
      throw new IllegalArgumentException("Session not in list.");
    }
  }
  /**
   * method is meant to check how many session objects are inside the session array list.
   * @return the amount of session in the list.
   */
  public int getNumberOfSessions()
  {
    return sessionList.size();
  }
  /**
   * method is meant to call specified session by its index.
   * The if-statement is used to check if the given index is not above the existing number of item in an array list
   * otherwise it would throw an exception.
   * @param index position of the session in the session array list.
   * @return session by specified index
   */
  public Session getSession(int index)
  {
    if (sessionList.size() >= index + 1)
    {
      return sessionList.get(index);
    }
    else
    {
      throw new ArrayIndexOutOfBoundsException(
          "Index out of bounds for SessionList. Entered index: " + index
              + ", highest possible index: " + (getNumberOfSessions() - 1));
    }
  }
  /**
   * method is intended to check if a given session is inside the session array list
   * @param session the session that is checked if it's in the array list.
   * @return boolean (true or false) if contains - true, else - false.
   */
  public boolean contains(Session session)
  {
    return sessionList.contains(session);
  }
  /**
   * method is meant to print out the session list. In the method a new s string variable is created.
   * In the method a for-loop is used to loop through the array list and one by the items are added to the s string.
   * @return the session list in a readable manner.
   */
  public String toString()
  {
    String s = "Sessions: ";
    for (int i = 0; i < sessionList.size(); i++)
    {
      s += "\n" + sessionList.get(i);
    }
    return s;
  }
}
