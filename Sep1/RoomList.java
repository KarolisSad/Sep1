import java.lang.reflect.Array;
import java.util.ArrayList;

public class RoomList
{
  private ArrayList<Room> rooms;

  public void addRoom(Room room)
  {
    rooms.add(room);
  }

  public ArrayList<Room> getNotBookedRooms()
  {
    ArrayList<Room> returnRoom = new ArrayList<>();
    for (int i = 0 ; i< rooms.size(); i ++)
    {
      if (!rooms.get(i).isBooked())
      {
        returnRoom.add(rooms.get(i));
      }
    }
    return returnRoom;
  }

}
