/**
 * The class represents sessions.
 * @author Group 8, the best group!
 */
public class Session
{
  private Course course;
  private int sessionLength;
  private DateTime startTime;
  private DateTime endTime;
  private Room room;

  /**
   * Four-argument constructor. Session length, start time and room are initialized by calling the set methods by those instance variables
   * and doing certain checks that are part of the set methods in the class. The course is initialized in a regular manner.
   * @param course one of the courses that should be assigned to the session.
   * @param sessionLength how long the session will take place.
   * @param startTime the time when the session should start.
   * @param room location, where the session will take place.
   */
  public Session(Course course, int sessionLength, DateTime startTime,
      Room room)
  {
    this.course = course;

    setSessionLength(sessionLength);
    setStartTime(startTime);
    setRoom(room);
  }

  /**
   * method calls the course for a given session.
   * @return course of a given session.
   */
  public Course getCourse()
  {
    return course;
  }

  /**
   * method calls the session length of given session.
   * @return the length of the given session.
   */
  public int getSessionLength()
  {
    return sessionLength;
  }

  /**
   * method calls session start time of given session.
   * @return the start time of the given session.
   */
  public DateTime getStartDateTime()
  {
    return startTime;
  }

  /**
   * method calls the session end time that is created in setStartTime().
   * @return the time for the end of the session.
   */
  public DateTime getEndDateTime()
  {
    return endTime;
  }

  /**
   * method calls room object and makes a copy of it.
   * @return a copy of a specified room.
   */
  public Room getRoom()
  {
    return room.copy();
  }

  /**
   * method is meant for setting a room for session. In the method it is checked if the room is chosen and otherwise it throws an exception.
   * If the room is chosen it compares the capacity of the room and the amount of students that belong to the course and if it's true is initializes it,
   * otherwise it will throw an exception.
   * @param room the room that the session should be held in.
   */
  public void setRoom(Room room)
  {
    if (room == null)
    {
      throw new IllegalArgumentException("Room should not be null.");
    }

    else
    {
      if (room.getCapacity() >= course.getCourseSize())
      {
        this.room = room;
      }

      else
      {
        throw new IllegalArgumentException(
            "Room too small to hold current course");
      }
    }
  }

  /**
   * method is meant to set start time and following that the end time of the given session.
   * It takes given time, when the session should start and initializes it as a copy.
   * Following that it initializes the end by adding the length of the session to the start time.
   * @param newStartTime the copy of a time for when the session should start.
   */
  public void setStartTime(DateTime newStartTime)
  {
    this.startTime = newStartTime.copy();
    this.endTime = new DateTime(startTime.getDate(),
        new Time(startTime.getTime().getHour() + sessionLength,
            startTime.getTime().getMinute()));
  }

  /**
   * method is meant to set session length.
   * In the method using the if-statement length value is checked and if it's not
   * 2, 3 or 4 it throws an exception.
   * @param sessionLength how long the session will take place.
   */
  public void setSessionLength(int sessionLength)
  {
    if (sessionLength == 2 || sessionLength == 3 || sessionLength == 4)
    {
      this.sessionLength = sessionLength;
    }
    else
    {
      throw new IllegalArgumentException(
          "Length Error - length should be 2, 3 or 4");
    }
  }

  /**
   * method is meant to compare two session objects if they are equal to each other.
   * @param obj
   * @return a boolean (true or false) if the objects are same or not.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Session))
    {
      return false;
    }
    Session other = (Session) obj;
    return course.equals(other.course) && sessionLength == other.sessionLength
        && startTime.equals(other.startTime) && room.equals(other.room);
  }

  /**
   * method meant to print out the given course information in a readable manner.
   * @return Information about the given course in a neat way.
   */
  public String toString()
  {
    return "Course: " + course.getCourseName() + ", Date: " + startTime.getDate() + ", Starting: "
        + startTime.getTime() + ", Ending: " + endTime.getTime() + ", Room: " + room;
  }
}

