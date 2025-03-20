public class CounterDecrementer implements Runnable
{
  private int update;
  private Counter counter;

  CounterDecrementer(Counter counter,int update)
  {
    this.counter = counter;
    this.update = update;
  }

  public void run()
  {
    for(int i = 0; i <update; i++)
    {
      counter.Decrement();
    }

    System.out.println(counter.getValue());
  }
}

