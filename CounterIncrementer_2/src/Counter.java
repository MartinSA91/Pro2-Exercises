public class Counter
{
  private long value;
  private long max;
  private long min;

  public Counter(long min, long max)
  {
    this.value = 0;
    this.max = max;
    this.min = min;
  }

  public synchronized void Increment()
  {
    while (value >=max)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //..
      }
    }
    {
      value++;

      notifyAll();
    }
  }
  public synchronized void Decrement()
  {
    while (value <= min)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //...
      }
      {
        value--;

        notifyAll();
      }
    }
  }

    public synchronized long getValue()
  {
      return value;
  }
}
