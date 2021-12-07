/**
 * DateTime class represents date and time.
 * @author Group 8.
 */
public class DateTime
{
  private Time time;
  private Date date;

  /**
   * Two-argument constructor. In the constructor the if-statement check is run to make sure that the date and time inputs are valid
   * if so it initializes them, otherwise it will throw an exception.
   * @param date given date object.
   * @param time given time object.
   */
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

  /**
   * method is meant to call time object.
   * @return time og of a specified time object.
   */
  public Time getTime()
  {
    return time;
  }

  /**
   * method is meant to call date object.
   * @return date og of a specified date object.
   */
  public Date getDate()
  {
    return date;
  }

  /**
   * method is meant to check if date and time of that date is before other
   * date and time of that day.
   * @param otherDateTime the date and time it's compared with
   * @return boolean (true or false) if before - true, else - false.
   */
  public boolean isBefore(DateTime otherDateTime)
  {
    return getDate().isBefore(otherDateTime.getDate())
        || getDate().equals(otherDateTime.getDate()) && getTime().isBefore(
        otherDateTime.getTime());
  }

  /**
   * method is meant to make a copy of the datetime object in a different class,
   * so it would be possible to edit it and not change it in the original class.
   * @return the copy of the specified datetime object.
   */
  public DateTime copy()
  {
    DateTime other = new DateTime(date, time);
    return other;
  }
}

