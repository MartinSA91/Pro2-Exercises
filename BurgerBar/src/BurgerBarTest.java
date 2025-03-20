public class BurgerBarTest
{
  public static void main(String[] args)
  {
    BurgerBar burgerBar = new BurgerBar(5); // Maks 5 burgere ad gangen

    Thread employee1 = new Thread(new BurgerBarEmployee(burgerBar, "Employee 1"));
    Thread employee2 = new Thread(new BurgerBarEmployee(burgerBar, "Employee 2"));

    Thread customer1 = new Thread(new BurgerBarCustomer(burgerBar, "Customer 1", 3));
    Thread customer2 = new Thread(new BurgerBarCustomer(burgerBar, "Customer 2", 4));
    Thread customer3 = new Thread(new BurgerBarCustomer(burgerBar, "Customer 3", 2));
    Thread customer4 = new Thread(new BurgerBarCustomer(burgerBar, "Customer 4", 5));
    Thread customer5 = new Thread(new BurgerBarCustomer(burgerBar, "Customer 5", 3));

    employee1.start();
    employee2.start();
    customer1.start();
    customer2.start();
    customer3.start();
    customer4.start();
    customer5.start();
  }
}
