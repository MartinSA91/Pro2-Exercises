package Mediator;

import java.io.BufferedReader;

public class ExerciseClientReader
{
  private BufferedReader in;
  private boolean running;
  private ExerciseClient client;

  public ExerciseClientReader(BufferedReader in, ExerciseClient client)
  {
    this.in = in;
    this.client = client;
    running = true;

  }

  public void close()
  {
    running = false;
  }

  public void receive()
  {
    try
    {
      String message = in.readLine();
      client.receiveMessage(message);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void run()
  {
    while (running)
    {
      try
      {
        String message = in.readLine();
        client.receiveMessage(message);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
