import java.util.ArrayList;

public class SessionList
{
  private ArrayList<Session> sessionList;

  // ADD to astah
  public SessionList()
  {
    this.sessionList = new ArrayList<>();
  }

  public boolean checkRoomAvailability(Session session)
  {
    for (int i = 0; i < sessionList.size(); i++)
    {
      if (session.equals(sessionList.get(i)))
      {
        throw new IllegalArgumentException("Session already added"); //working
      }

      else if (session.getRoom().getRoomNumber().equals(sessionList.get(i).getRoom()
          .getRoomNumber())) // if room is the same as another room in list
      {
        if (session.getStartTime().getDate().equals(sessionList.get(i).getStartTime().getDate()))
        {
          if (session.getStartTime().getTime().isBefore(sessionList.get(i).getEndTime().getTime())
              && !(session.getEndTime().getTime().isBefore(sessionList.get(i).getStartTime().getTime())))
          {
            throw new IllegalArgumentException(
                "Room already in use for selected time. Session: " + session + " not added\nCause: " + sessionList.get(i));
          }
        }
      }
    }
    return true;
  }

  public boolean checkStudentAvailability(Session session)
  {

    for (int i = 0; i < sessionList.size(); i++)
    {
      //for (int j = 0; j < session.getCourse().getStudentList().size(); j++)
      if (session.getCourse().getStudentList()
          .equals(sessionList.get(i).getCourse().getStudentList()))
      {
        throw new IllegalArgumentException(
            "Student overlap between two sessions");
      }
    }
    return true;
  }

  public void add(Session session)
  {
    for (int i = 0; i < sessionList.size(); i++)
    {
      if (sessionList.get(i).equals(session))
      {
        throw new IllegalArgumentException("Session already booked.");
      }
    }
    if (sessionList.isEmpty())
    {
      sessionList.add(session);
      return;
    }

    else if (checkRoomAvailability(session) && checkStudentAvailability(
        session))
    {
      sessionList.add(session);
    }

    else
    {
      throw new IllegalArgumentException(
          "It shouldn't be possible to reach this point");
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

  // TESTING
  public String toString()
  {
    String s = "";
    for (int i = 0; i < sessionList.size(); i++)
    {
      s += sessionList.get(i) + "\n";
    }

    return s;
  }
}
