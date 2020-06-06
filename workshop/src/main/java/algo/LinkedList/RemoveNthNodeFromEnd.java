package algo.LinkedList;

import algo.LinkedList.model.ListNode;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

// Given linked list: 1->2->3->4->5, and n = 2.
// After removing the second node from the end, the linked list becomes 1->2->3->5.
// Given n will always be valid.
//  1 -> 2 and n = 2
//  2

public class RemoveNthNodeFromEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {

    if (head == null) return head;
    if (head.next == null && n == 1) return null;

    ListNode remove = head;
    ListNode trail = null;

    while (remove != null) {

      int i = 0;
      ListNode tempRemove = remove;
      while (i < n) {
        i++;
        tempRemove = tempRemove.next;
      }
      if (tempRemove == null) { // remove the "remove" node

        if (remove == head) {
          ListNode curr = head.next;
          head.next = null;
          return curr;
        } else {
          trail.next = remove.next;
          remove.next = null;
          return head;
        }
      }

      remove = remove.next;
      trail = (trail == null) ? head : trail.next;
    }

    return head;
  }
}
