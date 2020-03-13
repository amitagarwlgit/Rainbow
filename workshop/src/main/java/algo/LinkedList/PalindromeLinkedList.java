package algo.LinkedList;

import algo.LinkedList.model.ListNode;

//
// Given a singly linked list, determine if it is a palindrome.
//
// Example 1:
//
// Input: 1->2
// Output: false
// Example 2:
//
// Input: 1->2->3->2->1
// Input: 1->2->3->4->4->3->2->1
// Output: true
// Follow up:
// Could you do it in O(n) time and O(1) space?

public class PalindromeLinkedList {

  public boolean isPalindrome(ListNode head) {
    ListNode middleNode = middle(head);
    ListNode revert = new ReverseLinkedList().reverseListIterative(middleNode);
    Boolean isPalindrome = true;
    while (revert != null) {
      if (head.val != revert.val) isPalindrome = false;
      head = head.next;
      revert = revert.next;
    }
    return isPalindrome;
  }

  private ListNode middle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    // 1->2->3->4->5
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverse(ListNode head) {
    return head;
  }
}
