package model;

public class DateTime
{
  private Time time;
  private Date date;

  public DateTime(Date date, Time time)
  {
    if (date.isLegal() && date.equals(date.today()) && time.isLegal() || date.isLegal() && !date.equals(date.today()))
    {
      this.date = date;
      this.time = time;
    }
    else
    {
    throw new IllegalArgumentException("Date Time error - Date and time should not be BEFORE today.");}
  }

  public Time getTime()
  {
    return time;
  }

  public Date getDate()
  {
    return date;
  }

  public boolean isBefore(DateTime otherDateTime)
  {
    return getDate().isBefore(otherDateTime.getDate())
        || getDate().equals(otherDateTime.getDate()) && getTime().isBefore(
        otherDateTime.getTime());
  }

  public DateTime copy()
  {
    DateTime other = new DateTime(date, time);
    return other;
  }
}

