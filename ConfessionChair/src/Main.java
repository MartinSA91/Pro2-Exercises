public class Main {
  public static void main(String[] args) {
    ConfessionChair confessionChair = new ConfessionChair();

    Thread churchgoer1 = new Thread(new Churchgoer(confessionChair, "Kirkegænger 1"));
    Thread churchgoer2 = new Thread(new Churchgoer(confessionChair, "Kirkegænger 2"));
    Thread churchgoer3 = new Thread(new Churchgoer(confessionChair, "Kirkegænger 3"));

    churchgoer1.start();
    churchgoer2.start();
    churchgoer3.start();
  }
}
