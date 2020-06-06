package algo.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/*
 * Lists: Contains list of objects. Java provides 3 type of ready to use list.
 * ArrayList: Growable Array in Size. Fast in Iteration and random access.
 *
 * Vector: Same as ArrayList, Difference being class is ThreadSafe.
 *         Use when List is accessed by multiple threads at the same time.
 *
 * LinkedList:
 */
public class ListTest {

  List l1 = new ArrayList();
  List l2 = new Vector();
  List l3 = new LinkedList();

  @Test
  public void testVector() {
    l2.add("coca");
    l2.add("cola");
  }
}
