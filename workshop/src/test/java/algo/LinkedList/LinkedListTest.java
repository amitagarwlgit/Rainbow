package algo.LinkedList;

import algo.LinkedList.model.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

  @Test
  public void testReversingLinkedList() {
    int[] arrayA = {4, 1, 8, 4, 5};
    ListNode input = generateLinkedList(arrayA);
    int inputSize = getLinkedListLength(input);
    ListNode output = new ReverseLinkedList().reverseListRecursion(input);
    Assertions.assertEquals(output.val, 5);
    Assertions.assertEquals(inputSize, getLinkedListLength(output));
  }

  @Test
  public void testInterstLinkedListByValue() {
    ListNode headA = generateLinkedList(new int[] {4, 1, 8, 4, 5});
    ListNode headB = generateLinkedList(new int[] {5, 0, 1, 8, 4, 5});
    ListNode output = new LinkedListIntersection().getIntersectionNode(headA, headB);
    Assertions.assertEquals(output.val, 1);
  }

  @Test
  public void testIntersectLinkedListByReference() {
    ListNode headA = generateLinkedList(new int[] {4, 1, 8, 4, 5});
    ListNode headB = new ListNode(5);
    headB.next = new ListNode(0);
    headB.next.next = new ListNode(9);
    headB.next.next.next = new ListNode(1);
    headB.next.next.next.next = headA.next.next;
    ListNode output = new LinkedListIntersection().getIntersectionNodeEfficient(headA, headB);
    Assertions.assertEquals(output.val, 8);
  }

  @Test
  public void testPalinderomLinkedList() {
    ListNode headA = generateLinkedList(new int[] {1, 2, 3, 2, 1});
    ListNode headB = generateLinkedList(new int[] {1, 2, 3, 4, 4, 3, 2, 1});
    ListNode headC = generateLinkedList(new int[] {1, 2});
    ListNode headD = generateLinkedList(new int[] {1, 2, 3, 4, 4, 3, 2, 1, 5});
    Assertions.assertTrue(new PalindromeLinkedList().isPalindrome(headA));
    Assertions.assertTrue(new PalindromeLinkedList().isPalindrome(headB));
    Assertions.assertFalse(new PalindromeLinkedList().isPalindrome(headC));
    Assertions.assertFalse(new PalindromeLinkedList().isPalindrome(headD));
  }

  private ListNode generateLinkedList(int[] intArr) {
    ListNode listNode = new ListNode(intArr[0]);
    for (int i = 1; i < intArr.length; i++) {
      addLinkedListNode(listNode, new ListNode(intArr[i]));
    }
    return listNode;
  }

  private void addLinkedListNode(ListNode head, ListNode node) {
    while (head.next != null) {
      head = head.next;
    }
    head.next = node;
  }

  private void displayLinkedList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.println(curr.val + "-->");
      curr = curr.next;
    }
  }

  private int getLinkedListLength(ListNode head) {
    int size = 0;
    ListNode curr = head;
    while (curr != null) {
      size += 1;
      curr = curr.next;
    }
    return size;
  }
}
