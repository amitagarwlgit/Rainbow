package algo.LinkedList;

import algo.LinkedList.model.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

  @Test
  public void testReversingLinkedList() {
    ListNode input = getLinkedList();
    int inputSize = getLinkedListLength(input);
    ListNode output = new ReverseLinkedList().reverseListIterative(input);
    Assertions.assertEquals(output.val, 5);
    Assertions.assertEquals(inputSize, getLinkedListLength(output));
  }

  private ListNode getLinkedList() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(4);
    listNode.next.next.next.next = new ListNode(5);
    listNode.next.next.next.next.next = null;
    return listNode;
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
