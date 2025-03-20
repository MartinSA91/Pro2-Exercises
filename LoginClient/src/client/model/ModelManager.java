package client.model;

import client.mediator.UserClient;

public class ModelManager implements Model
{
private UserClient userClient;

public ModelManager()
  {
    this.userClient = new UserClient("localhost", 2910);
  }

 public  void login(String username, String password)
  {
    userClient.login(username, password);
  }
}
