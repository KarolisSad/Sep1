/**
 * The class represents room.
 * @author Group 8.
 */
public class Room
{
  private int capacity;
  private String roomNumber;

  /**
   * Two-argument constructor. It initializes the capacity of the room as well as the room number.
   * @param capacity the amount of people that fits into the room.
   * @param roomNumber the name of the room.
   */
  public Room(int capacity, String roomNumber)
  {
    this.capacity = capacity;
    this.roomNumber = roomNumber;
  }

  /**
   * method call specified rooms capacity.
   * @return capacity of specified room.
   */
  public int getCapacity()
  {
    return capacity;
  }

  /**
   * method call specified rooms name (room number).
   * @return room number of specified room.
   */
  public String getRoomNumber()
  {
    return roomNumber;
  }

  /**
   * method is meant to make a copy of the room object in a different class,
   * so it would be possible to edit it and not change it in the original class.
   * @return the copy of the specified room object.
   */
  public Room copy()
  {
    Room other = new Room(capacity, roomNumber);
    return other;
  }

  /**
   * method is intended to present the room object in a readable manner.
   * @return room information (what's the number of the room and how many people can be fit in it).
   */
  public String toString()
  {
    return "Room Number: " + roomNumber + ", Capacity: " + capacity;
  }
}
