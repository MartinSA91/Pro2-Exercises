

public class Main
{
  public static void main(String[] args)
  {
    BlockingQueue queue = new BlockingQueue<>(5);
    System.out.println(queue);
    Thread producer = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        queue.put(i);
        System.out.println("Produced: " + i);
      }
    });
    Thread consumer = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        int item = queue.take();
        System.out.println("Consumed: " + item);
      }
    });


  }
}
