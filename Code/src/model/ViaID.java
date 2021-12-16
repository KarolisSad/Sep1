package model;

/**
 * An interface for controlling Student- and teacher IDs.
 *
 * @author Group 8Y
 * @version 1.0 - December 2021
 */

/**
 * The interface contains the following:
 *
 * @see TeacherID
 * @see StudentID
 */
public interface ViaID
{
  String getIdAsString();
  ViaID copy();
}
