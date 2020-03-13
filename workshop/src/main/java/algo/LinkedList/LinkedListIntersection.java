package algo.LinkedList;

import algo.LinkedList.model.ListNode;

// ListA: a1 --> a2 --> c1 --> c2 --> c3
// ListB: b1 --> b2 --> b3 --> c1 --> c2 --> c3
// Intersection Node: c1
//
//  [4,1,8,4,5]
//  [5,0,1,8,4,5]
//
//  ListNode pa = headA, pb = headB;
//        while (pa != pb) {
//            pa = (pa != null) ? pa.next : headB;
//            pb = (pb != null) ? pb.next : headA;
//        }
//        return pa;
//  pa = 4, pb = 5
//

public class LinkedListIntersection {

  // Technique 1: m + n == n + m
  // (where m is traversal length of first list and n is traversal length of second array)
  // This is suitable if we want to compare only address (reference) otherwise two values of same
  // list can be misunderstood as answer
  public ListNode getIntersectionNodeEfficient(ListNode headA, ListNode headB) {
    ListNode pa = headA, pb = headB;
    while (pa != pb) {
      pa = (pa != null) ? pa.next : headB;
      pb = (pb != null) ? pb.next : headA;
    }
    return pa;
  }

  // Technique 2: Find d = m - n
  // (where m is traversal length of first list and n is traversal length of second array)
  // jump the bigger array to d spots and then start comparing individulal elements.
  // Suitable for value comparision (will give first intersection value).
  // It works because intersection lists will have to co-incide eventually. They can't cross each
  // other.
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    int sizeA = getLinkedListSize(headA);
    int sizeB = getLinkedListSize(headB);
    int diff = Math.abs(sizeA - sizeB);
    ListNode biggerListHead = null;
    ListNode smallerListHead = null;
    ListNode intersectionNode = null;

    if (sizeA > sizeB) {
      biggerListHead = headA;
      smallerListHead = headB;
    } else {
      biggerListHead = headB;
      smallerListHead = headA;
    }

    for (int i = 0; i < diff; i++) {
      biggerListHead = biggerListHead.next;
    }

    while (biggerListHead != null && smallerListHead != null) {
      if (biggerListHead.val == smallerListHead.val) {
        intersectionNode = biggerListHead;
        break;
      }
      biggerListHead = biggerListHead.next;
      smallerListHead = smallerListHead.next;
    }
    return intersectionNode;
  }

  private int getLinkedListSize(ListNode head) {
    int size = 0;
    while (head != null) {
      size += 1;
      head = head.next;
    }
    return size;
  }
}
