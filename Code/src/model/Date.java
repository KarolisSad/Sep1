package model;

import java.time.LocalDate;

/**
 * Class representing a date.
 * @author Group 8.
 */
public class Date
{
  private int day;
  private int month;
  private int year;
  private String dayName;

  /**
   * Three-argument constructor. The first arguments (year) is initialized after an if-statement check is made if the year is current or later,
   * otherwise it will through an exception. The second argument (month) is initialized after it goes through an if-statement check, otherwise
   * it will throw an exception. The third argument (day) goes through a few if-statement checks to make sure that the input is valid
   * and after the checks the argument is initialized, otherwise it throws an exception.
   * dayName value is then initialized using the imported java.time.LocalDate class.
   * @param day depending on the month it's either 28, 29, 30 or 31.
   * @param month between 1-12
   * @param year 2021 and after.
   */
  public Date(int day, int month, int year)
  {
    if (year >= 2021)
    {
      this.year = year;
    }

    if (month > 0 && month <= 12)
    {
      this.month = month;
    }

    if ((day > 0) && (day <= 31))
    {
      if (day == 29 && month == 2 && isLeapYear())
      {
        this.day = day;
      }
      else if (day == 28 && month == 2)
      {
        this.day = day;
      }
      else if (day == 31)
      {
        if ((month == 2) || (month == 4) || (month == 6) || (month == 9) || (
            month == 11))
        {
          this.day = day;
        }
      }
      else
      {
        this.day = day;
      }
    }
    else
    {
      throw new IllegalArgumentException("Please enter a valid day");
    }

    this.dayName = LocalDate.of(year, month, day).getDayOfWeek().toString();
  }

  /**
   * method calls day of a specified date object.
   * @return day of the specified date.
   */
  public int getDay()
  {
    return day; // changed from string return
  }

  /**
   * method calls month of a specific date object.
   * @return month of the specified date.
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * method calls year of a specific date object.
   * @return year of the specified date.
   */
  public int getYear()
  {
    return year;
  }

  /**
   * method which returns the dayname (MONDAY, TUESDAY, ... etc) for the specific Date object
   * @return a String containing the name of the day.
   */
  public String getDayName()
  {
    return dayName;
  }

  /**
   * method is intended to check if a given date has a leap year.
   * It calculates if it's leap year using certain math equation.
   * @return boolean (true or false), if year is leap Year - true, else - false.
   */
  public boolean isLeapYear()
  {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  /**
   * method is meant to make a copy of the date object in a different class,
   * so it would be possible to edit it and not change it in the original class.
   * @return the copy of the specified date object.
   */
  public Date copy()
  {
    Date other = new Date(day, month, year);
    return other;
  }

  /**
   * method is meant to compare two Date objects if they are equal to each other.
   * @param obj
   * @return a boolean (true of false) if the objects are same or not.
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
    {
      return false;
    }
    Date other = (Date) obj;
    return day == other.day && month == other.month && year == other.year;
  }

  /**
   * method is intended to make the date readable.
   * It uses a method from java string library that automatically formats the given date.
   * @return well presented date.
   */
  public String toString()
  {
    return String.format("%04d-%02d-%02d", year, month, day);
    /*format "%02d:%02d:%02d" means that each value takes 2 "spaces"
      (0 is inserted first if number is only one cipher, AND separates numbers with colon) */
  }

  /**
   * method is intended to check if the given date is before other given date
   * @param otherDate the date that your date is compared with.
   * @return boolean (true or false), if it's before - true, else - false.
   */
  public boolean isBefore(Date otherDate)
  {
    return (this.year < otherDate.year || (this.year == otherDate.year && (
        this.month < otherDate.month || (this.month == otherDate.month && (
            this.day < otherDate.day)))));
  }
  /**
   * method intended to get the current date that is obtained from the computer date.
   * It uses LocalDate which is immutable date-time object.
   * @return the current date of your computer.
   */
  public Date today()
  {
    return new Date(LocalDate.now().getDayOfMonth(),
        LocalDate.now().getMonthValue(), LocalDate.now().getYear());
  }


  /**
   * method is meant to check if the current date of your computer is before a given date.
   * If the current date is not before the given date - it then checks that the given date is a weekday.
   * @return boolean (true or false),if the date is before the current date it's - false, otherwise it checks if the date is a weekday, and returns true if it is.
   */
  public boolean isLegal()
  {
    if (isBefore(today()) && !today().equals(this))
    {
      return false;
    }
    else
    {
      switch (this.dayName)
      {
        case "MONDAY":
        case "TUESDAY":
        case "WEDNESDAY":
        case "THURSDAY":
        case "FRIDAY":
          return true;
        default:
          throw new IllegalArgumentException(
              "You're trying to schedule a session on the weekend - that's just cruel :-( ");
      }
    }

  }

}
