public class Mailbox implements Runnable
{
  private int count;
  private final long RUNTIME = 100000;

  public Mailbox(int count)
  {
    this.count = 0;
  }

  public void run()
  {
    for (int i = 0; i < count; i++)
    {
      System.out.println(" new mail in your inbox... ");
      sleepTime();
    }
  }

private void sleepTime()
{
  try
  {
    Thread.sleep(200);
  } catch (InterruptedException e){
    e.printStackTrace();
  }
}
}
