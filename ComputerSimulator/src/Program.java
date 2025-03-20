public class Program implements Runnable
{
  private String program;
  private String action;
  private int count;
  private final long RUNTIME = 100000;

  public Program(String program, String action, int count)
  {
    this.program = program;
    this.action = action;
    this.count = count;
  }

  @Override public void run()
  {
    for (int i = 0; i<count;i++)
    {
      System.out.println(program + " wants to " + action);
      sleepRandomTime();
    }
  }

  private void sleepRandomTime()
  {
    try {
      Thread.sleep((int) (Math.random()*100) + 50);
    } catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
