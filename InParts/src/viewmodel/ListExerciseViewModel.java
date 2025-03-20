package viewmodel;

import javafx.beans.Observable;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Exercise;
import model.Model;

public class ListExerciseViewModel
{
  private ObservableList<SimpleExerciseViewModel> list;
  private ObjectProperty<SimpleExerciseViewModel> selectedExercise;
  private StringProperty errorProperty;
  private Model model;
  private ViewState viewState;

  public ListExerciseViewModel(Model model, ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;
    this.list = FXCollections.observableArrayList();
    this.selectedExercise = new SimpleObjectProperty<SimpleExerciseViewModel>();
    this.errorProperty = new SimpleStringProperty();
  }

  public void clear()
  {
    list.clear();
  }

  public void loadFromModel()
  {
    list.clear();
    for (Exercise exercise : model.getAllExercises())
    {
      addSimpleExercise(exercise);
    }
  }
public void addEdit(String number, String topic, int session, boolean completed)
  {
    Exercise exercise = new Exercise(session, Integer.parseInt(number), topic);
    if (model.getExercise(number) == null)
    {
      model.addExercise(exercise);
      addSimpleExercise(exercise);
    }
    else
    {
      model.editExercise(number, exercise);
      for (SimpleExerciseViewModel exerciseViewModel : list)
      {
        if (exerciseViewModel.getNumberProperty().get().equals(number))
        {
          exerciseViewModel.getTopicProperty().set(topic);
          exerciseViewModel.getCompletedProperty().set(completed);
          break;
        }
      }
    }
  }


public void remove()
  {
   if (selectedExerciseProperty().get() != null)
    {
     viewModelState.setNumber(selectedExerciseProperty.get().getNumberProperty.get)
    }
  }

  public ObservableList<SimpleExerciseViewModel> getAll()
  {
    return list;
  }

  public void setSelected(SimpleExerciseViewModel exerciseViewModel)
  {
    selectedExercise.set(exerciseViewModel);
  }

  public StringProperty errorPropertyProperty()
  {
    return errorProperty;
  }

  private void removeSimpleExercise(String number)
  {
    for (SimpleExerciseViewModel exercise : list)
    {
      if (exercise.getNumberProperty().get().equals(number))
      {
        list.remove(exercise);
        break;
      }
    }
  }
  private void addSimpleExercise(Exercise exercise)
  {
    list.add(new SimpleExerciseViewModel(exercise));
  }

}
