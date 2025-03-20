class BurgerbarEmployee implements Runnable {
  private final BurgerBar burgerBar;
  private final String name;

  public BurgerbarEmployee(BurgerBar burgerBar, String name) {
    this.burgerBar = burgerBar;
    this.name = name;
  }

  @Override
  public void run() {
    try {
      while (true) {
        burgerBar.makeBurger(name);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}

