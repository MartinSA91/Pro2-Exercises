public class Main
{
  public static void main(String[] args)
  {
    Log log1 = Log.getInstance("whatever.txt");
    Log log2 = Log.getInstance("måske.txt");

    log1.addLog("This is a log message");
    log1.addLog("This is another log message");
    log1.addLog("This is a third log message");
    log2.addLog("Halløj");

    System.out.println(log1);
    System.out.println(log2);
  }
}
