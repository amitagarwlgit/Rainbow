package algo.LinkedList;

import algo.LinkedList.model.ListNode;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;

// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where tail connects to the second node.

public class LinkedListCycle {

  public boolean hasCycle(ListNode head) {
    HashSet<ListNode> hashset = new HashSet<ListNode>();
    Boolean cycle = false;
    while (head != null) {
      if (hashset.contains(head)) {
        cycle = true;
        break;
      } else {
        hashset.add(head);
        head = head.next;
      }
    }

    return cycle;
  }

  public boolean hasCycleEfficient(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  //  Input: head = [3 --> |2| --> 0 --> -4 ]  [3 iterations, meet at -4]
  // Input: head = [3 --> 2 --> |0| --> -4 ]   [2 iterations, meet at 0]
  public ListNode detectCycleStart(ListNode head) {

    ListNode seeker = head;
    ListNode slow = head;
    ListNode fast = head;
    ListNode meetPoint = null;
    Boolean cycle = false;

    while (fast != null && fast.next != null) {

      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        cycle = true;
        meetPoint = slow;
        break;
      }
    }

    if (cycle == true) {
      while (seeker != meetPoint) {
        seeker = seeker.next;
        meetPoint = meetPoint.next;
      }
    }

    return meetPoint;
  }
}
