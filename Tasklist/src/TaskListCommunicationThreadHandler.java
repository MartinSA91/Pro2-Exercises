import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TaskListCommunicationThreadHandler implements Runnable
{
  private TaskList tasklist;
  private DataInputStream in;
  private DataOutputStream out;
  private String ip;
  private Socket socket;

  public TaskListCommunicationThreadHandler(Socket socket, TaskList tasklist)
      throws IOException
  {
   this.socket = socket;
    this.tasklist = tasklist;
    this.ip = socket.getInetAddress().getHostAddress();
    this.out = new DataOutputStream(socket.getOutputStream());
    this.in = new DataInputStream(socket.getInputStream());

  }

  public void run()
  {
    try
    {
      while (true)
      {
        String command = in.readUTF();
        System.out.println("Client> " + command);

        if ("ADD".equalsIgnoreCase(command))

        {
          String text = in.readUTF();
          long estimatedTime = in.readLong();
          Task task = new Task(text, estimatedTime);
          tasklist.add(task);
          out.writeUTF("client: " + ip + " added task: " + task );
        }
        else if ("GET".equalsIgnoreCase(command))
        {
          Task task = tasklist.getAndRemoveNextTask();
          if (task != null)
          {
            out.writeUTF("Next task: " + task);
            out.writeLong(task.getEstimatedTime());
            System.out.println("Server> " + task);
          }
          else
          {
            out.writeUTF("No tasks available");
          }
        }
        else if ("SIZE".equalsIgnoreCase(command))
        {
          int size = tasklist.size();
          out.writeInt(size);
        }
        else
        {
          out.writeUTF("Disconnected");
          break;
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        socket.close();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }

}
