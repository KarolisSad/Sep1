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
    //for (int i = 0; i <)
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

  public Room copy()
  {
    Room other = new Room(capacity, roomNumber);
    return other;
  }


  public String toString()
  {
    return roomNumber;
  }
}
