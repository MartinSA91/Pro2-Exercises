package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest
{

  @BeforeEach void setUp()
  {
  }

  @Test void add()
  {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(0, 1);
    assertEquals(1, list.get(0));
    list.add(1, 2);
    assertEquals(2, list.get(1));
    list.add(1, 3);
    assertEquals(3, list.get(1));
    list.add(0, 4);
    assertEquals(4, list.get(0));
    assertEquals(1, list.get(1));
    assertEquals(3, list.get(2));
    assertEquals(2, list.get(3));
  }

  @Test void indexOf()
  {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(0, 1);
    list.add(1, 2);
    list.add(2, 3);
    list.add(3, 4);
    assertEquals(0, list.indexOf(1));
    assertEquals(1, list.indexOf(2));
    assertEquals(2, list.indexOf(3));
    assertEquals(3, list.indexOf(4));
    assertEquals(-1, list.indexOf(5));
  }
}