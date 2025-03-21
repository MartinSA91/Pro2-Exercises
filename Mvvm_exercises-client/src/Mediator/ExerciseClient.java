package Mediator;

import com.google.gson.Gson;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Model;
import model.Exercise;

public class ExerciseClient
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private Gson gson;
  private List<ExercisePackage> receivedExercisePackages;
  private ExerciseListPackage receivedListPackage;
  private boolean waiting;
  private PropertyChangeSupport support;
  private ExerciseClientReader reader;


  public ExerciseClient(Model model, String host, int port) throws IOException
  {
    this.socket = new Socket(host, port);
    this.in = in;
    this.out = out;

    gson = new Gson();
    waiting = false;
    support = new PropertyChangeSupport(this);
    reader = new ExerciseClientReader(in, this);
     Thread thread = new Thread(reader:: run);
     thread.start();
  }

  public void disconnect()
  {
    try
    {
      socket.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public synchronized void received(String line)
  {
    Map<String, Object> map = gson.fromJson(message, Map.class);
    String type = (String) map.get("type");

    if (!"All".equals(type))
    {
      ExercisePackage received = gson.fromJson(message, ExercisePackage.class);
      if (waiting)
      {
        synchronized (this)
        {
          receivedExercisePackages.add(received);
          notifyAll();
        }
      }
      else
      {
        support.firePropertyChange(received.getType(), null, received);
      }
    }
    else
    {
      receivedListPackage = gson.fromJson(message, ExerciseListPackage.class);
      synchronized (this)
      {
        notifyAll();
      }
    }
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


  public ArrayList<Exercise> getAllExercises()
  {
    // Implement method to send request and wait for reply
    return null;
  }


  public Exercise getExercise(String number)
  {

    return null;
  }


  public Exercise removeExercise(String number)
  {

    return null;
  }

  public void addExercise(Exercise exercise)
  {

  }


  public Exercise editExercise(String number, Exercise exercise)
  {

    return null;
  }


  public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }


  public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

}
