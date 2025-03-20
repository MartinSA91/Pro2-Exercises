import java.lang.Runnable;

public class CounterIncrementer implements Runnable
{
  private int update;
  private Counter counter;

  CounterIncrementer(Counter counter,int update)
  {
    this.counter = counter;
    this.update = update;
  }

  public void run()
  {
    for(int i = 0; i <200000; i++)
    {
      counter.Increment();
    }

    System.out.println(counter.getValue());
  }
}
