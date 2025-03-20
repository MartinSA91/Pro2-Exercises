package client.mediator;

import client.model.Model;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class UserClient implements Model
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private Gson gson;



  public UserClient(String host, int port)
  {
    try
    {
      socket = new Socket(host, port);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      gson = new Gson();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }

  }

  public void login(String username, String password)
  {
    try
    {

      User user = new User(username, password);
      String json = gson.toJson(user);
      out.println(json);
      System.out.println("User: " + user);

      String response = in.readLine();
      if (response.equalsIgnoreCase("Success, you are now logged in"))

      {
        System.out.println(response);
      }
    else
      {
        throw new Exception("Error" + response);
      }
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }

  }

  public void disconnect()
  {
    try
    {
      out.println("DISCONNECT");
      socket.close();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }


}
