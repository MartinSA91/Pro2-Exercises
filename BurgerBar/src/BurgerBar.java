class BurgerBar {
  private int numberOfBurgers = 0;
  private final int maxNumberOfBurgers;

  public BurgerBar(int maxNumberOfBurgers) {
    this.maxNumberOfBurgers = maxNumberOfBurgers;
  }

  public synchronized void makeBurger(String employeeName) throws InterruptedException {
    while (numberOfBurgers >= maxNumberOfBurgers) {
      System.out.println(employeeName + " waiting to make burger. Max reached.");
      wait();
    }
    numberOfBurgers++;
    System.out.println(employeeName + " made a burger. Total: " + numberOfBurgers);
    notifyAll(); // Vækker tråde, der venter på en burger
  }

  public synchronized void eatBurger(String customerName) throws InterruptedException {
    while (numberOfBurgers <= 0) {
      System.out.println(customerName + " waiting for a burger. None available.");
      wait();
    }
    numberOfBurgers--;
    System.out.println(customerName + " ate a burger. Remaining: " + numberOfBurgers);
    notifyAll(); // Vækker tråde, der venter på at lave en burger
  }

  public synchronized int getNumberOfBurgers() {
    return numberOfBurgers;
  }
}