import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer
{
  private ServerSocket welcomeSocket;
  private TaskList tasklist;


  public TaskListServer(TaskList taskList, int port) throws IOException
  {

    this.welcomeSocket = new ServerSocket(port);
    this.tasklist = taskList;
    execute();
  }

  private void execute()
  {
    System.out.println("Starting Server. Waiting for clients...");
    while(true)
    {
      try
      {
        Socket socket = welcomeSocket.accept();
        System.out.println(
            "Client connected" + socket.getInetAddress().getHostAddress());

        TaskListCommunicationThreadHandler taskListCommunicationThreadHandler = new TaskListCommunicationThreadHandler(
            socket, tasklist);
        Thread thread = new Thread(taskListCommunicationThreadHandler);
        thread.start();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
