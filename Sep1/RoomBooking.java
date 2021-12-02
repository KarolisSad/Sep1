public class RoomBooking
{
  private Session session;
  private SessionList sessionList;

  public RoomBooking(Session session)
  {
    this.session = sessionList.getSession(session);
  }
}
