package External;

import view.TemperatureViewController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RunnableClock implements Runnable
{
  private TemperatureViewController controller;

  public RunnableClock(TemperatureViewController controller)
  {
    this.controller = controller;
  }

  @Override public void run()
  {
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    while(true) {
      LocalTime time = LocalTime.now();
      String timeString = time.format(timeFormatter);
      System.out.println(timeString);
      controller.showTime(timeString);

      try
      {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
