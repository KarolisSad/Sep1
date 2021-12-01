public class Session
{
  private Course course;
  private int length;
  private DateTime dateTime;
  private Room room;

  /**
   * Constructor for Session
   *
   * @param course   the course
   * @param length
   * @param dateTime
   * @param room
   */
  public Session(Course course, int length, DateTime dateTime, Room room)
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

    this.dateTime = dateTime.copy();

    if (course.getStudentList.size() <= room.getCapacity()
        && !(room.isBooked()))
    {
      this.room = room.copy;

      /* This definately shouldn't work...
      this.room.isBooked(dateTime, dateTime + (length * 45));

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

  public DateTime getDateTime()
  {
    return dateTime.copy();
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
    this.dateTime = newDateTime.copy();
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
        && dateTime.equals(other.dateTime) && room.equals(other.room);
  }

  public String toString()
  {
    return "Course: " + course + ", Date: " + dateTime.getDate() + ", Time: "
        + dateTime.getTime() + ", Room: " + room;
  }
}
