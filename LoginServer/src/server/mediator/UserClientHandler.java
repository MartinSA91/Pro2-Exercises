package server.mediator;

import com.google.gson.Gson;
import jdk.jfr.StackTrace;
import server.model.Model;
import server.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClientHandler implements Runnable
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private boolean running;
  private Gson gson;
  private String clientIp;
  private  Model model;

  public UserClientHandler(Socket socket, Model model) throws IOException
  {
    this.socket = socket;
    gson = new Gson();

    clientIp = socket.getInetAddress().getHostAddress();
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    out = new PrintWriter(socket.getOutputStream(), true);
    this.model = model;
  }

  public void close() throws IOException
  {
    socket.close();
  }

  public void run()
  {
    gson = new Gson();
    try {
      String clientText = in.readLine();
      System.out.println("Client: " + clientIp + "> " + clientText);

      UserPackage userPackage = gson.fromJson(clientText, UserPackage.class);
      System.out.println("User: " + userPackage);


      try {
       model.addUser(userPackage.getUser(), userPackage.getPassword());
        System.out.println("User added: " + userPackage.getUser());
       out.println("Success, you are now logged in");
      }
      catch (Exception e)
      {
        out.println(e.getMessage());
      }


    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
