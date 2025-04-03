public class Main
{
  public static void main(String[] args)
  {

    ThreadSafeLinkedList<Integer> list = new ThreadSafeLinkedList<>(ThreadSafeLinkedList.DOUBLE_LINKED_LIST);
    ThreadSafeLinkedList<Integer> list2 = new ThreadSafeLinkedList<>(ThreadSafeLinkedList.CIRCULAR_LINKED_LIST);
    ThreadSafeLinkedList<Integer> list3 = new ThreadSafeLinkedList<>(ThreadSafeLinkedList.LINEAR_LINKED_LIST);


    list.add(1);
    list.add(2);
    list.add(3);
    list2.add(4);
    list2.add(5);
    list3.add(6);
    list3.add(7);


    System.out.println("List: " + list);
    System.out.println("List2: " + list2);
    System.out.println("List3: " + list3);


    list.remove(2);


    System.out.println("List after removal: " + list);
    System.out.println("List2 after removal: " + list2);
    System.out.println("List3 after removal: " + list3);

  }
}
