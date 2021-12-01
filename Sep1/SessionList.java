import java.util.ArrayList;

public class SessionList
{
  private ArrayList<Session> sessionList;

  // ADD to astah
  public SessionList()
  {
    this.sessionList = new ArrayList<>();
  }

  public void add(Session session)
  {
    if (sessionList.isEmpty())
    {
      sessionList.add(session);
    }

    else
    {
      for (int i = 0; i < sessionList.size(); i++)
      {

        if (session.getRoom().equals(sessionList.get(i)
            .getRoom())) // IF SESSION IS IN SAME ROOM AS SessionList[i]
        {
          if (session.getStartTime().equals(sessionList.get(i)
              .getStartTime())) // If start time is identical to other session.
          {
            throw new IllegalArgumentException("Room already booked");
          }
          else if (session.getStartTime()
              .isBefore(sessionList.get(i).getEndTime())) // If start time is while another class is still in session in room
          {
            throw new IllegalArgumentException("Room already booked");
          }

          else
          {
            sessionList.add(session);
          }
        }
      }
    }
  }

  // Should maybe be changed in Astah?? Se examples below:
  public void removeSession(Session session)
  {
    sessionList.remove(session);
  }

  public Session getSession(Session session)
  {
    for (int i = 0; i < sessionList.size(); i++)
    {
      if (sessionList.get(i).equals(session))
        return sessionList.get(i);
    }

    throw new NullPointerException("Session not found");
  }

  // Might not be useable in our case - By index
  public Session getSessionByIndex(int index)
  {
    return sessionList.get(index);
  }

  // By TimeDate & Course - might be good?? - throws nullpointer-exception
  public Session getSessionByDateTimeAndCourse(DateTime dateTime, String course)
  {
    for (int i = 0; i < sessionList.size(); i++)
    {
      if (sessionList.get(i).getCourse().equals(course) && sessionList.get(i)
          .getStartTime().equals(dateTime))
        return sessionList.get(i);
    }

    throw new NullPointerException("Session not found");
  }

}
