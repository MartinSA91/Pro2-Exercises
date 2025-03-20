public class Counter
{
  private long value;

  public Counter()
  {
    this.value = 0;
  }

  public void Increment()
  {
    synchronized (this)
    {
      value++;
    }
  }

  public long getValue()
  {
    synchronized (this)
    {
      return value;
    }
  }
}
