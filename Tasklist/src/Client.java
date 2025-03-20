public class Client
{
  public static void main(String[] args)
  {
    final String host = "localhost";
    final int port = 5678;
    System.out.println("Starting Client...");

    TaskListClient client = new TaskListClient(host, port);

  }
}
