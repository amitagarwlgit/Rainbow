package algo.LinkedList;

import algo.LinkedList.model.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LinkedListTest {

  @Test
  public void testReversingLinkedList() {
    int[] arrayA = {4, 1, 8, 4, 5};
    ListNode input = generateLinkedList(arrayA);
    int inputSize = getLinkedListLength(input);
    ListNode output = new ReverseLinkedList().reverseListRecursion(input);
    Assertions.assertEquals(output.val, 5);
    Assertions.assertEquals(inputSize, getLinkedListLength(output));
    Assertions.assertFalse(isSorted(output));
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

  @Test
  public void testMergeSortedLinkedLists() {
    ListNode headA = generateLinkedList(new int[] {1, 2, 4});
    ListNode headB = generateLinkedList(new int[] {1, 2, 3});
    ListNode output1 = new MergeSortedLists().mergeTwoLists(headA, headB);
    ListNode output2 = new MergeSortedLists().mergeRecursion(headA, headB);
    Assertions.assertEquals(6, getLinkedListLength(output1));
    Assertions.assertTrue(isSorted(output1));
    Assertions.assertEquals(6, getLinkedListLength(output2));
    Assertions.assertTrue(isSorted(output2));
  }

  @Test
  public void testLinkedListCycle() {
    ListNode headA = generateLinkedList(new int[] {3, 2, 0, -4});
    headA.next.next.next.next = headA.next; // cycle
    ListNode headB = generateLinkedList(new int[] {1});
    ListNode headC = generateLinkedList(new int[] {1, 2, 3, 4, 5});
    Assertions.assertTrue(new LinkedListCycle().hasCycle(headA));
    Assertions.assertFalse(new LinkedListCycle().hasCycle(headB));
    Assertions.assertFalse(new LinkedListCycle().hasCycle(headC));
  }

  @Test
  public void testCopyWithRandomPointer() {
    Node newHead = new CopyWithRandomPointer().copyRandomList(getCopyRandomPointerCase1());
    Assertions.assertTrue(true);
  }

  private Node getCopyRandomPointerCase2() {
    int[] intArr = new int[] {3, 3, 3};
    Node head = new Node(intArr[0]);
    for (int i = 1; i < intArr.length; i++) {
      addLinkedListNode(head, new Node(intArr[i]));
    }

    head.random = null;
    head.next.random = head;
    head.next.next.random = null;
    return head;
  }

  private Node getCopyRandomPointerCase1() {
    int[] intArr = new int[] {7, 13, 11, 10, 1};
    Node head = new Node(intArr[0]);
    for (int i = 1; i < intArr.length; i++) {
      addLinkedListNode(head, new Node(intArr[i]));
    }

    head.random = null; // 7
    head.next.random = head; // 13
    head.next.next.random = head.next.next.next.next; // 11
    head.next.next.next.random = head.next.next; // 10
    head.next.next.next.next.random = head; // 1
    return head;
  }

  @Test
  public void testAddTwoNumbers()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    AddTwoNumbers addNum = new AddTwoNumbers();
    String methodToInvoke = "addTwoNumbers"; // addTwoNumbersConvert
    Method method = addNum.getClass().getMethod(methodToInvoke, ListNode.class, ListNode.class);

    ListNode case1 =
        (ListNode)
            method.invoke(
                addNum,
                generateLinkedList(new int[] {2, 3, 7}),
                generateLinkedList(new int[] {5, 6, 9, 8}));

    ListNode case2 =
        (ListNode)
            method.invoke(
                addNum, generateLinkedList(new int[] {5}), generateLinkedList(new int[] {5}));
    ListNode case3 =
        (ListNode)
            method.invoke(
                addNum,
                generateLinkedList(new int[] {5, 6, 9, 8}),
                generateLinkedList(new int[] {2, 3, 7}));

    ListNode case4 =
        (ListNode)
            method.invoke(
                addNum, generateLinkedList(new int[] {0}), generateLinkedList(new int[] {7, 3}));

    ListNode case5 =
        addNum.addTwoNumbersConvert(
            generateLinkedList(new int[] {0}), generateLinkedList(new int[] {7, 3}));

    Assertions.assertEquals(addNum.getNum(case1), 9697);
    Assertions.assertEquals(addNum.getNum(case2), 10);
    Assertions.assertEquals(addNum.getNum(case3), 9697);
    Assertions.assertEquals(addNum.getNum(case4), 37);
  }

  private ListNode generateLinkedList(int[] intArr) {
    ListNode listNode = new ListNode(intArr[0]);
    for (int i = 1; i < intArr.length; i++) {
      addLinkedListNode(listNode, new ListNode(intArr[i]));
    }
    return listNode;
  }

  private void addLinkedListNode(ListNode head, ListNode node) {
    while (head.next != null) head = head.next;
    head.next = node;
  }

  private void addLinkedListNode(Node head, Node node) {
    while (head.next != null) head = head.next;
    head.next = node;
  }

  private void displayLinkedList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.println(curr.val + "-->");
      curr = curr.next;
    }
  }

  private Boolean isSorted(ListNode head) {
    Boolean isSorted = true;
    while (head != null) {
      if (head.next == null) break;
      if (head.val > head.next.val) isSorted = false;
      head = head.next;
    }
    return isSorted;
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
