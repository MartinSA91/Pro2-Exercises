import java.io.IOException;

public class Server
{
  public static void main(String[] args) throws IOException
  {
    final int port = 5678;
    System.out.println("Starting Server...");

    TaskList taskList = new TaskList();
    TaskListServer server = new TaskListServer(taskList, port);
  }
}
