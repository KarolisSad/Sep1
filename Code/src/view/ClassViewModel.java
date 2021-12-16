package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClassViewModel
{
  private StringProperty classNameProperty;
  private IntegerProperty semesterProperty;

  public ClassViewModel(Class myClass)
  {
    classNameProperty = new SimpleStringProperty(myClass.getClassID());
    semesterProperty = new SimpleIntegerProperty(myClass.getSemester());
  }

  public StringProperty getClassNameProperty()
  { return classNameProperty; }

  public IntegerProperty getSemesterProperty()
  { return semesterProperty; }


}
