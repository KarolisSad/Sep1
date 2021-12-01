import java.util.ArrayList;

public class SessionList
{
  private ArrayList<Session> sessionList;

  // ADD to astah
  public SessionList()
  {
    this.sessionList = new ArrayList<>();
  }

  public void addSession(Session session)
  {
    for (int i = 0; i < sessionList.size(); i++)
    {
      if (sessionList.get(i).getRoom().equals(session.getRoom()))
      {
        if (sessionList.get(i).getStartTime().getTime().getHour() > session.getStartTime().getTime().getHour())
        {

        }
      }
    }

    sessionList.add(session);
  }

  // Should maybe be changed in Astah?? Se examples below:
  public void removeSession(Session session)
  {

    /*
    Could instead be something like:

    removeSession(DateTime dateTime, String course)
    {
    sessionList.remove(getSessionByDateTimeAndCourse(dateTime, course));
    }
     */
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
