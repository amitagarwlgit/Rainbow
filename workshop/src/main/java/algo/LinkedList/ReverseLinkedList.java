package algo.LinkedList;

// Reverse a singly linked list.
// Example:
// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
// Follow up:
// A linked list can be reversed either iteratively or recursively. Could you implement both?

import algo.LinkedList.model.ListNode;

public class ReverseLinkedList {

  public ListNode reverseListRecursion(ListNode head) {
    return recurse(head, null);
  }

  private ListNode recurse(ListNode head, ListNode state) {
    if (head == null) return state;
    ListNode curr = head.next;
    head.next = state;
    state = head;
    return recurse(curr, state);
  }

  public ListNode reverseListIterative(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }
}