import java.util.ArrayList;

public class RoomList
{
  private ArrayList<Room> roomList;
  private SessionList sessionList;

  public RoomList(SessionList sessionList)
  {
    this.roomList = new ArrayList<>();
    this.sessionList = sessionList;
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

  public SessionList getSessionList()
  {
    return sessionList;
  }

  public boolean isRoomAvailable(Room room, DateTime startTime,
      DateTime endTime)
  {
    for (int i = 0; i < sessionList.numberOfSessions(); i++)
    {
      if (room.getRoomNumber()
          .equals(sessionList.getSessionByIndex(i).getRoom().getRoomNumber()))
      {
        if (startTime.getDate()
            .equals(sessionList.getSessionByIndex(i).getStartTime().getDate()))
        {
          if (startTime.getTime()
              .isBefore(sessionList.getSessionByIndex(i).getEndTime().getTime())
              && !(endTime.getTime().isBefore(
              sessionList.getSessionByIndex(i).getStartTime().getTime())))
          {
            return false;
          }
        }
      }
    }
    return true;
  }

  public RoomList getAvailableRooms(DateTime startTime, DateTime endTime)
  {
    RoomList availableRooms = new RoomList(sessionList);
    for (int i = 0; i < roomList.size(); i++)
    {
      if (isRoomAvailable(roomList.get(i), startTime, endTime))
      {
        availableRooms.addRoom(roomList.get(i));
      }
    }
    if (availableRooms.getNumberOfRooms() == 0)
    {
      throw new NullPointerException("No rooms available for current time: " + startTime + " to " + endTime);
    }
    return availableRooms;
  }

  public String toString()
  {
    String s = "";
    for (Room i : roomList)
    {
      s += i + ", ";
    }
    return s;
  }
}
 /* {
    this.roomList = new ArrayList<>();
    allSessions = null;
  }

  public void setSessionList(SessionList allSessions)
  {
    this.allSessions = allSessions;
  }

  public SessionList getAllSessions()
  {
    return allSessions;
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

  public void removeRoom(Room room)
  {
    roomList.remove(room);
  }

  public int getNumberOfRooms()
  {
    return roomList.size();
  }

  public boolean contains(Room room)
  {
    return roomList.contains(room);
  }

  public Room getRoom(int index)
  {
    return roomList.get(index);
  }


  /*      MESSY

  public ArrayList<Session> convertSessionList(SessionList sessionList)
  {
    ArrayList<Session> allSessionsAL = new ArrayList<>();
    for (int i = 0; i < sessionList.numberOfSessions(); i++)
    {
      allSessionsAL.add(sessionList.getSessionByIndex(i));
    }
    return allSessionsAL;
  }

  public void addRoomToAvailableList(Room room)
  {
    if (!(roomList.contains(room)))
    {
      roomList.add(room);
    }
  }

   */


  /*    I FORGOT WHY THIS IS HERE

  public RoomList getAvailableRooms(DateTime startTime, DateTime endTime)
  {
    convertSessionList(allSessions);

    RoomList availableRooms = new RoomList(allSessions);

    for (int i = 0; i < allSessions.numberOfSessions(); i++)
    {
      if (convertSessionList(allSessions).contains(allSessions.))
        if (!(roomList.contains(allSessions.getSessionByIndex(i).getRoom())))
        {
          availableRooms.addRoom(roomList.get(i));
        }
    } return availableRooms;
  }

   */


