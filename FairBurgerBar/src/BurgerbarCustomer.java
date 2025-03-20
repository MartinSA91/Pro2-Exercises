class BurgerbarCustomer implements Runnable {
  private final BurgerBar burgerBar;
  private final String name;
  private final int burgersToEat;

  public BurgerbarCustomer(BurgerBar burgerBar, String name, int burgersToEat) {
    this.burgerBar = burgerBar;
    this.name = name;
    this.burgersToEat = burgersToEat;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < burgersToEat; i++) {
        burgerBar.eatBurger(name);
        Thread.sleep(1500);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
