import java.util.ArrayList;

public class RoomList
{
  private ArrayList<Room> roomList;

  public RoomList()
  {
    this.roomList = new ArrayList<>();
  }

  public void addRoom(Room room)
  {
    roomList.add(room);
  }

  public void removeRoom(int index)
  {
    roomList.remove(index);
  }

  public Room getRoom(int index)
  {
    return roomList.get(index);
  }

  public int getNumberOfRooms()
  {
    return roomList.size();
  }

  public boolean contains(Room room)
  {
    return roomList.contains(room);
  }

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
