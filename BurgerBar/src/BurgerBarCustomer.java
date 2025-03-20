public class BurgerBarCustomer implements Runnable
{

  private  BurgerBar burgerBar;
  private  String name;
  private  int burgersToEat;

  public BurgerBarCustomer(BurgerBar burgerBar, String name, int burgersToEat) {
    this.burgerBar = burgerBar;
    this.name = name;
    this.burgersToEat = burgersToEat;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < burgersToEat; i++) {
        burgerBar.eatBurger(name);
        Thread.sleep(1500); // Simulerer tid til at spise en burger
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
