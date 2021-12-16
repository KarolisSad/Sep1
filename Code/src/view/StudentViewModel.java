package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Student;

public class StudentViewModel
{
  private StringProperty nameProperty;
  private IntegerProperty studentIDProperty;
  private StringProperty classIDProperty;
  private IntegerProperty semesterProperty;

  public StudentViewModel(Student student)
  {
    nameProperty = new SimpleStringProperty(student.getName());
    studentIDProperty = new SimpleIntegerProperty(Integer.parseInt(student.getStudentId()));
    classIDProperty = new SimpleStringProperty(student.getClassID());
    semesterProperty = new SimpleIntegerProperty(student.getSemester());
  }

  public StringProperty getNameProperty()
  { return nameProperty; }

  public IntegerProperty getStudentIDProperty()
  { return studentIDProperty; }

  public StringProperty getClassIDProperty()
  { return classIDProperty; }

  public IntegerProperty getSemesterProperty()
  { return semesterProperty; }

}
