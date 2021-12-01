public class Room
{
  private int capacity;
  private String roomNumber;
  private boolean isBooked;

  public Room(int capacity, String roomNumber)
  {
    this.capacity = capacity;
    this.roomNumber = roomNumber;
    this.isBooked = false;
  }

  //Change method name in Astah

  public boolean isBookedAtTime(DateTime startDateTime, DateTime endDateTime)
  {
    // Should maybe go to RoomBooking class - loop through SessionList and see if room is booked during time in arguments

    return true;
  }

  public int getCapacity()
  {
    return capacity;
  }

  public String getRoomNumber()
  {
    return roomNumber;
  }

  public boolean isBooked()
  {
    return isBooked;
  }
}
