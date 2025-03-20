

public class TestCounter
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    CounterIncrementer c1 = new CounterIncrementer(counter, 200000);
    CounterIncrementer c2 = new CounterIncrementer(counter, 200000);

    Thread t1 = new Thread(c1, "incrementer1");
    Thread t2 = new Thread(c2, "incrementer2");

    t1.start();
    t2.start();

    try
    {
      t1.join();
      t2.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    System.out.println(Thread.currentThread().getName() + ": " + counter.getValue());
  }
}
