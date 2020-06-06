package algo.LinkedList;

import algo.LinkedList.model.ListNode;

import java.util.List;

// Input: 3->5->6, 1->3->4
// result 1   (1,2,4) (3,4)
// Output: 1->1->2->3->4->4

public class MergeSortedLists {

  public ListNode mergeRecursion(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val < l2.val) {
      l1.next = mergeRecursion(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeRecursion(l1, l2.next);
      return l2;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode result = null;

    if (l1.val < l2.val) {
      result = new ListNode(l1.val);
      l1 = l1.next;
    } else {
      result = new ListNode(l2.val);
      l2 = l2.next;
    }

    ListNode curr = result;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = new ListNode(l1.val);
        l1 = l1.next;
        curr = curr.next;
      } else {
        curr.next = new ListNode(l2.val);
        l2 = l2.next;
        curr = curr.next;
      }
    }

    while (l1 != null) {
      curr.next = new ListNode(l1.val);
      l1 = l1.next;
      curr = curr.next;
    }

    while (l2 != null) {
      curr.next = new ListNode(l2.val);
      l2 = l2.next;
      curr = curr.next;
    }
    return result;
  }
}
