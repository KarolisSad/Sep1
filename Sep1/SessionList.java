import java.util.ArrayList;

public class SessionList
{
  private ArrayList<Session> sessionList;

  public SessionList()
  {
    this.sessionList = new ArrayList<>();
  }

  public void addSession(Session session)
  {
    if (sessionList.isEmpty())
    {
      sessionList.add(session);
    }

    /*
    else if (isSessionBookable(session))
    {
      sessionList.add(session);
    }
    else
      throw new IllegalArgumentException("Session not added :-(");

     */
  }


  public boolean contains(Session session)
  {
    return sessionList.contains(session);
  }


  /*
  public boolean checkRoomAvailability(Session session)
  {
    for (int i = 0; i < sessionList.size(); i++)
    {
      if (session.equals(sessionList.get(i)))
      {
        throw new IllegalArgumentException("Session already added"); //working
      }

      else if (session.getRoom().getRoomNumber().equals(
          sessionList.get(i).getRoom()
              .getRoomNumber())) // if room is the same as another room in list
      {
        if (session.getStartTime().getDate()
            .equals(sessionList.get(i).getStartTime().getDate()))
        {
          if (session.getStartTime().getTime()
              .isBefore(sessionList.get(i).getEndTime().getTime())
              && !(session.getEndTime().getTime()
              .isBefore(sessionList.get(i).getStartTime().getTime())))
          {
            throw new IllegalArgumentException(
                "Room already in use for selected time. Session: " + session
                    + " not added\nCause: " + sessionList.get(i));
          }
        }
      }
    }
    return true;
  }

   */

  /*

  public boolean isSessionBookable(Session session)
  {
    if (sessionList.isEmpty())
    {
      return true;
    }
    else if (checkStudentAvailability(session) && checkRoomAvailability(
        session))
    {
      return true;
    }
    else
    return false;
  }

   */


  /*
  public boolean isSessionBookable(Session session)
  {
    if (sessionList.isEmpty())
    {
      return true;
    }
    else if (session.getRoomList().isRoomAvailable(session.getRoom(), session.getStartTime(),
        session.getEndTime()) && checkStudentAvailability(session))
    {
      return true;
    }

    return false;
  }

   */

/*

  public boolean checkStudentAvailability(Session session)
  {

    for (int i = 0; i < sessionList.size(); i++)
    {
      if (session.getCourse().getClassStudentList()
          .equals(sessionList.get(i).getCourse().getClassStudentList()))
      {
        for (Session value : sessionList)
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
                  "Students already in session for selected time. Session: "
                      + session + " not added\nCause: " + value);
            }
          }
        }
      }

    }
    return true;
  }

  public int numberOfSessions()
  {
    return sessionList.size();
  }

  public void removeSession(Session session)
  {
    sessionList.remove(session);
  }

  public Session getSession(Session session)
  {
    for (Session value : sessionList)
    {
      if (value.equals(session))
        return value;
    }

    throw new NullPointerException("Session not found");
  }

  public Session getSessionByIndex(int index)
  {
    return sessionList.get(index);
  }

  // TESTING
  public String toString()
  {
    String s = "";
    for (Session session : sessionList)
    {
      s += session + "\n";
    }

    return s;
  }

  ////////////////////    MISC    \\\\\\\\\\\\\\\\\\\\

/*    Tried to combine both availability methods - error in isRoomAvailable
  public boolean isSessionBookable(Session session)
  {
  if (sessionList.isEmpty())
      {
        return true;
      }
   else if (session.getRoomList().isRoomAvailable(session.getRoom(), session.getStartTime(),
          session.getEndTime()) && checkStudentAvailability(session))
      {
        return true;
      }

    return false;
  }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



                This whole part SHOULD be where we check availability for students in the course but not in the same class.
      else
      {
        int looping = 0;
        while (looping < session.getCourse().getClassStudentList().size())
        {
          for (int b = 0;
               b < session.getCourse().getClassStudentList().size(); b++)
          {
            if (!session.getCourse().getCourseStudentList().getStudent(b)
                .equals(session.getCourse().getClassStudentList().getStudent(
                    looping)))  // IF student at index b in CourseStudentList is NOT a part of classStudentList, add them to studentNotInMainClass
            {

            }
            looping++;
          }
        }
      }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  // By TimeDate & Course - might be good?? - throws nullpointer-exception

  public Session getSessionByDateTimeAndCourse(DateTime dateTime, String course)
  {
    for (Session session : sessionList)
    {
      if (session.getCourse().equals(course) && session.getStartTime()
          .equals(dateTime))
        return session;
    }

    throw new NullPointerException("Session not found");
  }

 */
}
