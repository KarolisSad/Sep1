public class Session
{
  private Course course;
  private int length;
  private DateTime startTime;
  private DateTime endTime;
  private Room room;

  /**
   * Constructor for Session
   *
   * @param course    the course
   * @param length
   * @param startTime
   * @param room
   */
  public Session(Course course, int length, DateTime startTime, Room room)
  {
    this.course = course;

    if (length == 2 || length == 3 || length == 4)
    {
      this.length = length;
    }
    else
    {
      throw new IllegalArgumentException(
          "Length Error - length should be 2, 3 or 4");
    }

    this.startTime = startTime.copy();

    if (course.getStudentListSize() <= room.getCapacity() && !(room.isBooked()))
    {
      this.room = room.copy();

      /*
      this.room.isBooked(startTime, endTime);

       */

    }
    else
    {
      throw new IllegalArgumentException("Room to small to hold students.");
    }

  }

  public Course getCourse()
  {
    return course;
  }

  public int getLength()
  {
    return length;
  }

  public DateTime getStartTime()
  {
    return startTime.copy();
  }

  public Room getRoom()
  {
    return room.copy();
  }

  // Change in astah: room -> newRoom
  public void changeRoom(Room newRoom)
  {
    this.room = newRoom.copy();
  }

  // Change in astah: dateTime -> newDateTime
  public void changeStartTime(DateTime newDateTime)
  {
    this.startTime = newDateTime.copy();
  }

  // toString + equals might not be needed?

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Session))
    {
      return false;
    }
    Session other = (Session) obj;
    return course.equals(other.course) && length == other.length
        && startTime.equals(other.startTime) && room.equals(other.room);
  }

  public String toString()
  {
    return "Course: " + course + ", Date: " + startTime.getDate() + ", Time: "
        + startTime.getTime() + ", Room: " + room;
  }
}
