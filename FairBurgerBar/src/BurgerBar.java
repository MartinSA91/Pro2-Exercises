class BurgerBar {
  private int numberOfBurgers = 0;
  private final int maxNumberOfBurgers;
  private int nextNumberToTake = 0;
  private int nextNumberToServe = 0;

  public BurgerBar(int maxNumberOfBurgers) {
    this.maxNumberOfBurgers = maxNumberOfBurgers;
  }

  public synchronized void makeBurger(String employeeName) throws InterruptedException {
    while (numberOfBurgers >= maxNumberOfBurgers) {
      wait();
    }
    numberOfBurgers++;
    System.out.println(employeeName + " lavede en burger. Total: " + numberOfBurgers);
    notifyAll();
  }

  public synchronized void eatBurger(String customerName) throws InterruptedException {
    int myNumber = nextNumberToTake++;

    while (myNumber != nextNumberToServe || numberOfBurgers <= 0) {
      wait();
    }

    numberOfBurgers--;
    System.out.println(customerName + " spiste en burger. Burgere tilbage: " + numberOfBurgers);
    nextNumberToServe++;
    notifyAll();
  }
}
