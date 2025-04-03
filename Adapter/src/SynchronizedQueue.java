public class SynchronizedQueue<T> implements QueueADT<T>
{

  private CircularLinkedList<T> queue;

  public SynchronizedQueue(int type)
  {
    queue = new CircularLinkedList<>();
  }

  @Override public void enqueue(T element)
  {

  }

  @Override public T dequeue()
  {
    return null;
  }

  @Override public T first()
  {
    return null;
  }

  @Override public int indexOf(T element)
  {
    return 0;
  }

  @Override public boolean isEmpty()
  {
    return false;
  }

  @Override public boolean isFull()
  {
    return false;
  }

  @Override public int size()
  {
    return 0;
  }

  @Override public int capacity()
  {
    return 0;
  }

  public boolean contains(T element)
  {
    return false;
  }

  @Override public String toString()
  {
    return null;
  }

  public synchronized void enqueueSynchronized(T element)
  {
    queue.add(element);
  }

  
}
