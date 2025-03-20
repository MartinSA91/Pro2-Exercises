

public class TestCounter
{
  public static void main(String[] args)
  {
    Counter counter = new Counter(-2000, 2000);
    CounterIncrementer c1 = new CounterIncrementer(counter, 200);
    CounterDecrementer c2 = new CounterDecrementer(counter, 200);
    CounterIncrementer b1 = new CounterIncrementer(counter, 200);
    CounterDecrementer b2 = new CounterDecrementer(counter, 200);

    Thread t1 = new Thread(c1, "incrementer1");
    Thread t2 = new Thread(c2, "decrementer1");
    Thread t3 = new Thread(b1, "incrementer2");
    Thread t4 = new Thread(b2, "decrementer2");

    t1.start();
    t2.start();
    t3.start();
    t4.start();

    try
    {
      t1.join();
      t2.join();
      t3.join();
      t4.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    System.out.println(Thread.currentThread().getName() + ": " + counter.getValue());
  }
}
