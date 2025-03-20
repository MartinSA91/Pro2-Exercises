package server.mediator;

import server.model.Model;
import server.model.User;
import server.model.UserList;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserServer implements Runnable
{
  private UserPackage userPackage;
  private UserPackage returnPackage;
  private Model model;

  private final int PORT = 2910;
  private boolean running;
  private ServerSocket welcomeSocket;

  public UserServer(Model model)
  {
    this.model = model;
    userPackage = null;
    returnPackage = null;
    running = true;
  }

  public void close()
  {
    running = false;
  }

  @Override public void run()
  {
      try
      {
        System.out.println("Starting Server.");
        welcomeSocket = new ServerSocket(PORT);
        while (true)
        {
          System.out.println("Waiting for clients...");
          Socket socket = welcomeSocket.accept();
          UserClientHandler c = new UserClientHandler(socket, model);
          System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
          Thread t = new Thread(c);
          t.start();
        }
    }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
  }
}
