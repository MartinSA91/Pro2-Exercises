public interface Buffer<T> extends QueueADT<T>
{
  void put(T element);
  T take();
  T look();
  boolean isEmpty();
  boolean isFull();
  int size();
}


