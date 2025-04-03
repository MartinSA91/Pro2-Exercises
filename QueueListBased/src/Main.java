public class Main
{
  public static void main(String[] args)
  {
    QueueListBased<Integer> queue = new QueueListBased<>(0);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    System.out.println("Queue: " + queue);

    System.out.println("Dequeue: " + queue.dequeue());
    System.out.println("First: " + queue.first());
    System.out.println("Queue after dequeue: " + queue);

    System.out.println("Index of 3: " + queue.indexOf(3));
    System.out.println("Contains 4: " + queue.contains(4));
    System.out.println("Is empty: " + queue.isEmpty());
    System.out.println("Size: " + queue.size());
  }
}
