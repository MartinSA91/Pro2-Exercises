public class Main {
  public static void main(String[] args) {
    Thermometer t1 = new Thermometer("t1", 15, 1);
    Thermometer t2 = new Thermometer("t2", 15, 7);

    Thread thread1 = new Thread(t1);
    Thread thread2 = new Thread(t2);

    thread1.start();
    thread2.start();
  }
}
