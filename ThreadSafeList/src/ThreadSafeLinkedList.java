public class ThreadSafeLinkedList<T> implements ListADT<T> {

  public final static int LINEAR_LINKED_LIST = 1;
  public final static int CIRCULAR_LINKED_LIST = 2;
  public final static int DOUBLE_LINKED_LIST = 3;
  private ListADT<T> realSubject;

  public ThreadSafeLinkedList(int type) {
    switch (type) {
      case LINEAR_LINKED_LIST:
        realSubject = new LinearLinkedList<>();
        break;
      case CIRCULAR_LINKED_LIST:
        realSubject = new CircularLinkedList<>();
        break;
      case DOUBLE_LINKED_LIST:
        realSubject = new DoubleLinkedList<>();
        break;
      default:
        throw new IllegalArgumentException("Invalid list type");
    }
  }

  @Override
  public synchronized void add(int index, T element) {
    realSubject.add(index, element);
  }

  @Override
  public synchronized void add(T element) {
    realSubject.add(element);
  }

  @Override
  public synchronized void set(int index, T element) {
    realSubject.set(index, element);
  }

  @Override
  public synchronized T get(int index) {
    return realSubject.get(index);
  }

  @Override
  public synchronized T remove(int index) {
    return realSubject.remove(index);
  }

  @Override
  public synchronized T remove(T element) {
    return realSubject.remove(element);
  }

  @Override
  public synchronized int indexOf(T element) {
    return realSubject.indexOf(element);
  }

  @Override
  public synchronized boolean contains(T element) {
    return realSubject.contains(element);
  }

  @Override
  public synchronized boolean isEmpty() {
    return realSubject.isEmpty();
  }

  @Override
  public synchronized boolean isFull() {
    return realSubject.isFull();
  }

  @Override
  public synchronized int size() {
    return realSubject.size();
  }

  public String toString() {
    return realSubject.toString();
  }
}