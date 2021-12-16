package model;

import java.time.LocalTime;
/**
 * The class that represents time.
 *
 * @author Group 8.
 * Version 1.0 December 2021
 */
public class Time
{
  private int hour;
  private int minute;
  /**
   * Two-argument constructor.
   * Each instance variable goes through a check to make sure that inputs are not only possible,
   * but also fits the schedule structure (possible start time and end time, etc).
   * If the inputs are invalid it throws an exception.
   * @param hour represents an hour of a day
   * @param minute represents a minute of a day.
   */
  public Time (int hour, int minute)
  {
    if ((hour > 7) && (hour < 20))
    {
      this.hour = hour;
    }
    else
    {
      throw new IllegalArgumentException(
          "Please enter an hour that is more than 8 and less then 20");
    }

    if(minute < 60 && minute >= 0)
    {
      if (hour == 8 && minute >= 20)
      {
        this.minute = minute;
      }
      else if (hour == 19 && minute <= 35)
      {
        this.minute = minute;
      }
      else
      {
        this.minute = minute;
      }
    }
    else
    {
      throw new IllegalArgumentException(
          "please enter a valid minute between [1-59]");
    }
  }
  /**
   * method is meant to get an hour of time object.
   * @return hour.
   */
  public int getHour()
  {
    return hour;
  }
  /**
   * method is meant to get the minute-value of time object.
   * @return minute.
   */
  public int getMinute()
  {
    return minute;
  }
  /**
   * method is meant to check is one time is before other time.
   * @param time2 the other time
   * @return boolean, is before - true, else - false.
   */
  public boolean isBefore(Time time2)
  {
    return hour < time2.hour || hour == time2.hour && minute < time2.minute
        || hour == time2.hour && minute == time2.minute;
  }

  /**
   * method is meant for making a copy of time object,
   * since Time class has a composition relationship with DateTime class
   * @return a copy of time object.
   */
  public Time copy()
  {
    Time other = new Time (hour, minute);
    return other;
  }
  /**
   * method is meant to compare two time objects if they are equal to each other.
   * @param obj
   * @return a boolean, true - equal, else - false.
   */
  public boolean equals (Object obj)
  {
    if (!(obj instanceof Time))
    {
      return false;
    }
    Time other = (Time)obj;
    return minute == other.minute && hour == other.hour;
  }
  /**
   * method is meant to get local time of a computer.
   * @return local time.
   */
  public Time today()
  {
    return new Time(LocalTime.now().getHour(), LocalTime.now().getMinute());
  }
  /**
   * method is meant to check if the time given is before current time.
   * @return boolean, true - if time is not before, else - false.
   */
  public boolean isLegal()
  {
    if (isBefore(today()) && !today().equals(this))
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  /**
   * method is intended to make the time readable.
   * It uses a method from java string library that automatically formats the given time.
   * @return well presented time.
   */
  public String toString()
  {
    return String.format("%02d:%02d", hour, minute);
    /*format "%02d:%02d:%02d" means that each value takes 2 "spaces"
      (0 is inserted first if number is only one cipher, AND separates numbers with colon) */
  }
}
