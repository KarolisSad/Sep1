package view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import mediator.ScheduleModel;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import model.*;
import model.Class;

import java.util.Optional;

public class CourseViewController
{
  // Window data fields:
  @FXML private TableView<CourseViewModel> courseTable;
  @FXML private TableColumn<CourseViewModel, String> nameColumn;
  @FXML private TableColumn<CourseViewModel, Integer> ectsColumn;
  @FXML private TableColumn<CourseViewModel, String> classColumn;
  @FXML private TableColumn<CourseViewModel, String> teacherColumn;

  Region root;
  private ViewHandler viewHandler;
  private ScheduleModel model;
  private CourseViewListModel viewModel;


  public CourseViewController()
  {

  }


  public void init(ViewHandler viewHandler, Region root, ScheduleModel model)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new CourseViewListModel(model);

    // Passing information to TableColumns
    nameColumn.setCellValueFactory(
        cellData -> cellData.getValue().getFinalCourseNameProperty());
    ectsColumn.setCellValueFactory(
        cellData -> cellData.getValue().getEctsProperty().asObject());
    classColumn.setCellValueFactory(
        cellData -> cellData.getValue().getMainClassProperty());
    teacherColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTeacherProperty());


    courseTable.setItems(viewModel.getList());

  }

  public void reset()
  {
    viewModel.update();
  }

  public Region getRoot()
  {
    return root;
  }

  public void addButton()
  {
    viewHandler.openView("addCourseView");
  }


  /**
   * The method will send the user to the main window
   */
  @FXML private void main() { viewHandler.openView("main"); }

  /**
   * The method will send the user to the classView window
   */
  @FXML private void classView() {viewHandler.openView("class");}

  /**
   * The method will send the user to the studentView window
   */
  @FXML private void student() { viewHandler.openView("studentView"); }

  /**
   * The method will send the user to the teacherView window
   */
  @FXML private void teacher() { viewHandler.openView("teacherView"); }

  /**
   * The method will send the user to the main window sessionView window
   */
  @FXML private void session() {viewHandler.openView("sessionView");}

  /**
   * The method will send the user to the roomView window
   */
  @FXML private void room() { viewHandler.openView("roomView"); }

  /**
   * The method will send the user to the main window
   */
  @FXML private void backButton()
  {
    viewHandler.openView("main");
  }


  /**
   * removes the selected course from the selected course
   * */
  @FXML private void removeButton()
  {
    try
    {


      CourseViewModel selectedItem = courseTable.getSelectionModel().getSelectedItem();

      boolean remove = confirmation();
      if (remove)
      {
        Course course = new Course(selectedItem.getCourseNameProperty().get(),selectedItem.getEctsProperty().get(),new Class(selectedItem.getClassIdProperty().get(),selectedItem.getSemesterProperty().get()),new Teacher(selectedItem.getTeacherProperty().get(),new TeacherID(selectedItem.getTeacherIdProperty().get())));
        model.removeCourseBy(selectedItem.getCourseNameProperty().get(),selectedItem.getEctsProperty().get(),selectedItem.getClassNameProperty().get(),selectedItem.getTeacherIdProperty().get());
        System.out.println(model.getCourseSize());
        viewModel.remove(course);
        courseTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      System.out.println("Item not found");
    }
    model.exportAll();
  }


  /**
   * shows confirmation window with chosen course to remove
   * @return ture if remove course, false if don't remove a course
   */
  public boolean confirmation()
  {
    int index = courseTable.getSelectionModel().getFocusedIndex();
    CourseViewModel selectedItem = courseTable.getItems().get(index);
    if (index < 0 || index >= courseTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Removing Course {"+selectedItem.getCourseNameProperty().get()+":" + selectedItem.getTeacherIdProperty().get()+"}");
    Optional<ButtonType> result = alert.showAndWait();
    return  (result.isPresent())&&(result.get()==ButtonType.OK);
  }

  /**
   * The method will send the user to the addStudent window
   */
  @FXML private void addStudent()
  {
   viewHandler.openView("addStudentToCourseView");

  }

  /**
   * The method will send the user to the removeStudent window
   */
@FXML private void removeStudent()
  {
    viewHandler.openView("removeStudentFromCourse");
  }



}
