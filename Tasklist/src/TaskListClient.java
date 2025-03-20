import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskListClient
{
  private Socket socket;
  private DataOutputStream out;
  private DataInputStream in;
  private Scanner input;

  public TaskListClient(String host, int port)
  {
    try
    {
      socket = new Socket(host, port);
      out = new DataOutputStream(socket.getOutputStream());
      in = new DataInputStream(socket.getInputStream());
      input = new Scanner(System.in);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    execute();
  }
  private void execute()
  {
    try
    {
      while (true)
      {
        System.out.println("Enter a command: ");
        String command = input.nextLine();
        out.writeUTF(command);
        if ("ADD".equalsIgnoreCase(command))
        {
          System.out.println("Enter a task: ");
          String text = input.nextLine();
          System.out.println("Enter estimated time: ");
          long estimatedTime = input.nextLong();
          input.nextLine();
          out.writeUTF(text);
          out.writeLong(estimatedTime);
          System.out.println(in.readUTF());
        }
        else if ("GET".equalsIgnoreCase(command))
        {
          System.out.println(in.readUTF());

        }
        else if ("SIZE".equalsIgnoreCase(command))
        {
          System.out.println(in.readInt());
        }
        else
        {
          System.out.println("Invalid command");
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
