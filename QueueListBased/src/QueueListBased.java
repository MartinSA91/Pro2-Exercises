public class QueueListBased<T> implements QueueADT<T>

{
  private ListADT<T> list;

  public QueueListBased(int type)
  {

        list = new CircularLinkedList<>();
    }

  @Override public void enqueue(T element)
  {
    list.add(element);
  }

  @Override public T dequeue()
  {
    return list.remove(0);
  }

  @Override public T first()
  {
    return list.get(0);
  }

  @Override public int indexOf(T element)
  {
    return list.indexOf(element);
  }

  @Override public boolean isEmpty()
  {
    return list.isEmpty();
  }

  @Override public boolean isFull()
  {
    return list.isFull();
  }

  @Override public int size()
  {
    return list.size();
  }

  @Override public int capacity()
  {
    return Integer.MAX_VALUE;
  }
    public boolean contains(T element)
  {
    return list.contains(element);
  }

  @Override public String toString()
  {
    return list.toString();
  }
}

