public class BlockingQueue<T> implements Buffer<T>
{
  private int capacity;

  public BlockingQueue(int capacity)
  {
    this.capacity = capacity;
  }


  @Override synchronized public void put(T element)
  {

  }

  @Override synchronized public T take()
  {
    return null;
  }

  @Override synchronized public T look()
  {
    return null;
  }

  @Override synchronized public boolean isEmpty()
  {
    return true;
  }

  @Override synchronized public boolean isFull()
  {
    return false;
  }

  @Override synchronized public int size()
  {
    return 0;
  }

  @Override public String toString()
  {
    return "BlockingQueue{" +
        "capacity=" + capacity +
        '}';
  }
}
