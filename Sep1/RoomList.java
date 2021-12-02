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
    if (roomList.contains(room))
    {
      throw new IllegalArgumentException("Already added: " + room);
    }
    else
    {
      roomList.add(room);
    }
  }

  public RoomList getAvailableRooms(DateTime startTime, DateTime endTime)
  {
    RoomList notBookedRooms = new RoomList();

    for (int i = 0; i < roomList.size(); i++)
    {
      if (!(roomList.get(i).isBookedAtTime(startTime, endTime)))
      {
        notBookedRooms.addRoom(roomList.get(i));
      }
    }
    return notBookedRooms;
  }
}

