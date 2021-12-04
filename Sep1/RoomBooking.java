public class RoomBooking
{
  private SessionList allSessions;
  private RoomList allRooms;
  private DateTime startTime, endTime;

  public RoomBooking(RoomList allRooms, DateTime startTime, DateTime endTime, SessionList allSessions)
  {
    this.allRooms = allRooms;
    this.startTime = startTime.copy();
    this.endTime = endTime.copy();
    this.allSessions = allSessions;
  }

 /* public RoomList getAvailableRooms()
  {
    RoomList availableRooms = new RoomList(allSessions);
    if (allSessions.numberOfSessions() == 0)
    {
      availableRooms = allRooms;
      return availableRooms;
    }
    else
    {
      for (int j = 0; j < allSessions.numberOfSessions(); j++)
      {

        for (int i = 0; i < allRooms.getNumberOfRooms(); i++)
        {
          if (!(allRooms.getRoom(i).getRoomNumber().equals(
              allSessions.getSessionByIndex(j).getRoom()
                  .getRoomNumber()))) // Checks if room is NOT currently used for any planned sessions
          {
            availableRooms.addRoom(allRooms.getRoom(i));
          }

          else
          {
            if (!(allSessions.getSessionByIndex(j).getStartTime().getDate()
                .equals(
                    startTime.getDate()))) // if above true: checks if it is used on the date we are trying to book
            {
              if (!(allSessions.getSessionByIndex(j).getStartTime().getTime()
                  .isBefore(endTime.getTime())
                  && !(allSessions.getSessionByIndex(j).getEndTime().getTime()
                  .isBefore(
                      startTime.getTime())))) // if true: checks that planned sessions START-time IS NOT before this END-time
              // and that END-time of planned session IS before start of this.
              {
                availableRooms.addRoom(allRooms.getRoom(i));
              }
            }
          }
        }
      }
    }
    return availableRooms;
  }

  /*
  public Boolean isAvailable(DateTime startTime, DateTime endTime)
  {
    for (int j = 0; j < allSessions.numberOfSessions(); j++)
    {
      for (int i = 0; i < allRooms.getNumberOfRooms(); i++)
        if (allRooms.getRoom(i).getRoomNumber()
            .equals(allSessions.getSessionByIndex(j).getRoom().getRoomNumber()))
        {
          if (!(allSessions.getSessionByIndex(j).getStartTime().getDate()
              .equals(startTime.getDate())))
          {
            if (!(allSessions.getSessionByIndex(j).getStartTime().getTime()
                .isBefore(endTime.getTime()) && !(allSessions.getSessionByIndex(
                j).getEndTime().getTime().isBefore(startTime.getTime()))))
            {

              return
            }
          }
        }

      if (allSessions.contains())
        if (allSessions.getSessionByIndex(i).getRoom().getRoomNumber().equals())
          if (session.getRoom().getRoomNumber().equals(value.getRoom()
              .getRoomNumber())) // if room is the same as another room in list
          {
            if (session.getStartTime().getDate()
                .equals(value.getStartTime().getDate()))
            {
              if (session.getStartTime().getTime()
                  .isBefore(value.getEndTime().getTime())
                  && !(session.getEndTime().getTime()
                  .isBefore(value.getStartTime().getTime())))
              {
                throw new IllegalArgumentException(
                    "Room already in use for selected time. Session: " + session
                        + " not added\nCause: " + value);
              }
            }
          }
    } return true;
  }

   */
}
