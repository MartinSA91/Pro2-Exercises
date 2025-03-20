package External;

import view.TemperatureViewController;

public class ClockTest
{
  public static void main(String[] args)
  {
    Thread clockThread = new Thread(new RunnableClock(new TemperatureViewController()));
    clockThread.start();
  }


}
