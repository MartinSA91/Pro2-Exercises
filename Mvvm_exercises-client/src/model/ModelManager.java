package model;

import Mediator.ExerciseClient;
import Mediator.ExercisePackage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class ModelManager implements Model
{

  private PropertyChangeSupport property;
  private ArrayList<Exercise> exercises;
  private PropertyChangeListener listener;
  private final static String HOST = "10.154.198.69";
  private final static int PORT = 2910;
  private ExerciseClient exerciseClient;
  


  public ModelManager()
  {
    property = new PropertyChangeSupport(this);
    exercises = new ArrayList<>();
    try
    {
      exerciseClient = new ExerciseClient(this,HOST,PORT);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
    listener = new PropertyChangeListener()
    {
      @Override public void propertyChange(PropertyChangeEvent evt)
      {

      }
    };


  }

  @Override public ArrayList<Exercise> getAllExercises()
  {
    return exerciseClient.getAllExercises();
  }
    private synchronized ExercisePackage waitForReply(String type, String number)
    {
      ExercisePackage received = null;
      boolean found = false;
      while (!found)
      {
        while (!receivedExercisePackages.isEmpty())
        {
          received = receivedExercisePackages.remove(receivedExercisePackages.size() - 1);
          found = (received.getError() != null
              || type.equals(received.getType()) && number.equals(received.getNumber()));
          if (found)
          {
            break;
          }
        }
        if (!found)
        {
          try
          {
            wait();
          }
          catch (InterruptedException e)
          {
            e.printStackTrace();
          }
        }
      }
      if (received.getError() != null)
      {
        throw new IllegalStateException(received.getError());
      }
      return received;
    }
  }

  @Override public Exercise getExercise(String number)
  {
    return exerciseClient.getExercise();
  }

  @Override public Exercise removeExercise(String number)
  {
    return exerciseClient.removeExercise();
  }

  @Override public void addExercise(Exercise exercise)
  {
    exerciseClient.addExercise();
  }

  @Override public Exercise editExercise(String number, Exercise exercise)
  {
    return exerciseClient.editExercise();
  }

  @Override public void addListener(PropertyChangeListener listener)
  {

  }

  @Override public void removeListener(PropertyChangeListener listener)
  {

  }


}
