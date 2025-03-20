import client.mediator.UserClient;
import client.model.ModelManager;
import client.model.Model;

import java.util.Scanner;

public class UserClientTest
{
  public static void main(String[] args)
  {
    Model model = new ModelManager();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter username: ");
    String username = scanner.nextLine();
    System.out.println("Enter password: ");
    String password = scanner.nextLine();

  }
}
