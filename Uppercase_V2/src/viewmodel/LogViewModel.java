package viewmodel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
public class LogViewModel implements PropertyChangeListener

{
  private Model model;
  private ObservableList<String> logs;

  public LogViewModel(Model model)
  {
    this.model = model;
    this.logs = FXCollections.observableArrayList();
    model.addListener(this);
  }

  public ObservableList<String> getLogs()
  {
    return logs;
  }

  @Override public void propertyChange(PropertyChangeEvent event)
  {
    Platform.runLater(() -> logs.add(event.getNewValue().toString()));
  }
}
