package model;

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
   * Four-argument constructor. Session length, start time, end time and room are initialized by calling the set methods by those instance variables
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
    setEndTime();
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
   * method calls session start time of given session.
   * @return the start time of the given session.
   */
  public int getSessionLength()
  {
    return sessionLength;
  }
  /**
   * method calls the session start time that is created in setStartTime().
   * @return the DateTime for the start of the session.
   */
  public DateTime getStartDateTime()
  {
    return startTime;
  }

  /**
   * method calls the session end time that is created in setEndTime().
   * @return the DateTime for the end of the session.
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
   * method is meant to set start time for a given session.
   * It takes given time, when the session should start and checks if the hour and minute values are allowed.
   * If the time value are allowed, a copy is taken of startTime.
   * If the time value is not allowed, and exception is thrown.
   * @param startTime the copy of a time for when the session should start.
   */
  public void setStartTime(DateTime startTime)
  {
    switch (startTime.getTime().getHour())
    {
      case 8:
        if (startTime.getTime().getMinute() == 20)
          this.startTime = startTime.copy();
        break;
      case 9:
        if (startTime.getTime().getMinute() == 10)
          this.startTime = startTime.copy();
        break;
      case 10:
        if (startTime.getTime().getMinute() == 15)
          this.startTime = startTime.copy();
        break;
      case 12:
        if (startTime.getTime().getMinute() == 45)
          this.startTime = startTime.copy();
        break;
      case 13:
        if (startTime.getTime().getMinute() == 30)
          this.startTime = startTime.copy();
        break;
      default:
        throw new IllegalArgumentException(
            "Illegal Start Time for Session. Legal Start Times are: 8:20, 9:10, 10:15, 12:45 and 13:30");
    }
  }

  /**
   * method is meant to set end time for a given session.
   * It checks the startTime of the session and the length of the session, and assigns a new endTime if the sessionLength is compatible with the startTime.
   * If the sessionLength is not compatible with the startTime, an exception is thrown.
   */
  public void setEndTime()
  {
    switch (startTime.getTime().getHour())
    {
      case 8:
        switch (sessionLength)
        {
          case 2:
            this.endTime = new DateTime(startTime.getDate(), new Time(9, 55));
            break;
          case 3:
            this.endTime = new DateTime(startTime.getDate(), new Time(11, 0));
            break;
          case 4:
            this.endTime = new DateTime(startTime.getDate(), new Time(11, 50));
            break;
        }
        break;

      case 9:
        switch (sessionLength)
        {
          case 2:
            this.endTime = new DateTime(startTime.getDate(), new Time(11, 0));
            break;
          case 3:
            this.endTime = new DateTime(startTime.getDate(), new Time(11, 45));
            break;
          default:
            throw new IllegalArgumentException(
                "Session length too long for start-time: 9:10, try a shorter length");
        }
        break;
      case 10:
        if (sessionLength == 2)
        {
          this.endTime = new DateTime(startTime.getDate(), new Time(11, 50));
          break;
        }
        else
        {
          throw new IllegalArgumentException(
              "Session length too long for start-time: 10:15, try a shorter length");
        }


      case 12:
        switch (sessionLength)
        {
          case 2:
            this.endTime = new DateTime(startTime.getDate(), new Time(14, 20));
            break;
          case 3:
            this.endTime = new DateTime(startTime.getDate(), new Time(15, 5));
            break;
          case 4:
            this.endTime = new DateTime(startTime.getDate(), new Time(16, 05));
            break;
        }
        break;

      case 13:
        switch (sessionLength)
        {
          case 2:
            this.endTime = new DateTime(startTime.getDate(), new Time(15, 5));
            break;
          case 3:
            this.endTime = new DateTime(startTime.getDate(), new Time(16, 05));
            break;
          default:
            throw new IllegalArgumentException(
                "Session length too long for start-time: 13:30, try a shorter length");
        }
        break;
      case 14:
        if (sessionLength == 2)
        {
          this.endTime = new DateTime(startTime.getDate(), new Time(16, 05));
          break;
        }
        else
        {
          throw new IllegalArgumentException(
              "Session length too long for start-time: 14:20, try a shorter length");
        }
        

    }

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
    return "Course: " + course.getCourseName() + ", Date: "
        + startTime.getDate() + ", Starting: " + startTime.getTime()
        + ", Ending: " + endTime.getTime() + ", Room: " + room;
  }
}

