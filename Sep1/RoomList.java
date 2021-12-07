import java.util.ArrayList;

/**
 * The class stores an array list of all existing rooms as well as a few method that will help interact with said rooms.
 * @author Group 8.
 */
public class RoomList
{
  private ArrayList<Room> roomList;

  /**
   * One-argument constructor. In the constructor we initialize the instance variable as a new array list that will store a list of rooms.
   */
  public RoomList()
  {
    this.roomList = new ArrayList<>();
  }

  /**
   * The method is meant to add a new room to the existing room list.
   * @param room the room that needs to be added to the array list.
   */
  public void addRoom(Room room)
  {
    roomList.add(room);
  }

  /**
   * The method is meant to remove a room from the existing room list by the rooms index.
   * @param index the position in the room array list of the room that needs to be removed.
   */
  public void removeRoom(int index)
  {
    roomList.remove(index);
  }

  /**
   * method is meant to find a room from the room array list by room's index.
   * In the method if-statement is used to check if the array list is larger or equal to the given index
   * to make sure that the index is correct. Otherwise, it will throw an exception.
   * @param index position in the array list of the room that we need to find.
   * @return the room with specified index (position in an array list).
   */
  public Room getRoom(int index)
  {
    if (roomList.size() >= index + 1)
    {
      return roomList.get(index);
    }
    else
    {
      throw new ArrayIndexOutOfBoundsException(
          "Index out of bounds for RoomList. Entered index: " + index
              + ", highest possible index: " + (getNumberOfRooms() - 1));
    }
  }

  /**
   * method intended to get a room object stored in the array list by room's number.
   * In the method for-loop is used to loop through all the objects in the array list
   * and an if-statement to compare the given room number with the ones in the list.
   * If it is not found it will throw an exception.
   * @param roomNumber room number according to which the room has to found.
   * @return room by specified room number.
   */
  public Room getRoomByRoomNumber(String roomNumber)
  {
    for (int i = 0; i < roomList.size(); i++)
    {
      if (roomList.get(i).getRoomNumber().equals(roomNumber))
      {
        return roomList.get(i);
      }
    }

    throw new IllegalArgumentException("Room with name: " + roomNumber + " not found.");
  }

  /**
   * method is meant to get the amount of room object are stored in the room array list.
   * @return number of room object in the room array list.
   */
  public int getNumberOfRooms()
  {
    return roomList.size();
  }

  /**
   * method is meant to check if given room is part of a created room array list.
   * @param room the room that is checked if it's part of the array list.
   * @return boolean (true of false), if contains - true, else - false.
   */
  public boolean contains(Room room)
  {
    return roomList.contains(room);
  }

  /**
   * method is meant to print out the room array list in a readable manner.
   * a new s string variable is created to store the list of rooms.
   * for-loop is used to go through all the items in an array list and store it into the s
   * string each in a different line.
   * @return s variable with a list of rooms.
   */
  public String toString()
  {
    String s = "";
    for (Room i : roomList)
    {
      s += i + "\n";
    }
    return s;
  }
}
