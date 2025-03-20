class Churchgoer implements Runnable {
  private final ConfessionChair confessionChair;
  private final String name;
  private final String[] sins = {
      "Jeg stjal slik fra min lillesøster",
      "Jeg løj for min chef",
      "Jeg tog den sidste småkage uden at spørge"
  };

  public Churchgoer(ConfessionChair confessionChair, String name) {
    this.confessionChair = confessionChair;
    this.name = name;
  }

  @Override
  public void run() {
    try {
      for (String sin : sins) {
        confessionChair.enterConfessionBooth(name, sin);
        int penance = confessionChair.leaveConfessionBooth(name);

        // Simuler at kirkegængeren beder Ave Maria
        for (int i = 0; i < penance; i++) {
          System.out.println(name + " siger Ave Maria (" + (i + 1) + "/" + penance + ")");
          Thread.sleep(1000); // 1 sek pr. bøn
        }

        // Simuler tid mellem skriftemål
        Thread.sleep(5000);
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}

