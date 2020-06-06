package algo.LinkedList;

import algo.LinkedList.model.ListNode;

import java.util.List;

// Sort a linked list in O(n log n) time using constant space complexity.
//
// Input: 4->2->6->3->5->1
// Output: 1->2->3->4->5->6

public class SortLinkedList {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    // mergesort(head)

    return head;
  }

  private void mergesort(ListNode head) {
    ListNode middle = middle(head);
  }

  private ListNode middle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode merge(ListNode headA, ListNode headB) {
    if (headA == null) return headB;
    if (headB == null) return headA;

    if (headA.val < headB.val) {
      headA.next = merge(headA.next, headB);
      return headA;
    } else {
      headB.next = merge(headA, headB.next);
      return headB;
    }
  }
}
