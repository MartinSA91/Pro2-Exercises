public class BurgerBarEmployee implements Runnable
{
  private BurgerBar burgerBar;
  private  String name;

  public BurgerBarEmployee(BurgerBar burgerBar, String name) {
    this.burgerBar = burgerBar;
    this.name = name;
  }

  @Override
  public void run() {
    try {
      while (true) {
        burgerBar.makeBurger(name);
        Thread.sleep(1000); // Simulerer tid til at lave en burger
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
