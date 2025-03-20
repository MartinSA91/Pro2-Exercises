class ConfessionChair {
  private boolean occupied = false;
  private int penance = 0;

  public synchronized void enterConfessionBooth(String name, String sin) throws InterruptedException {
    while (occupied) {
      wait();
    }
    occupied = true;
    System.out.println(name + " bekender: " + sin);
    // Simuler præstens vurdering af bod
    penance = (int) (Math.random() * 20) + 1;
  }

  public synchronized int leaveConfessionBooth(String name) {
    System.out.println(name + " får bod: " + penance + " Ave Maria");
    occupied = false;
    notify();
    return penance;
  }
}
