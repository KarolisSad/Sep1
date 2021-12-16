package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Room;

public class RoomViewModel
{
  private StringProperty nameProperty;
  private IntegerProperty capacityProperty;

  public RoomViewModel(Room room)
  {
    nameProperty = new SimpleStringProperty(room.getRoomNumber());
    capacityProperty = new SimpleIntegerProperty(room.getCapacity());
  }

  public StringProperty getNameProperty()
  { return nameProperty; }

  public IntegerProperty getCapacityProperty()
  { return capacityProperty; }


}
