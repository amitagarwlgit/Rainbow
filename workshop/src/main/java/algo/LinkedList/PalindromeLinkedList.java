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
    ListNode reverse = reverse(middle(head));
    Boolean isPalindrome = true;
    while (reverse != null) {
      if (head.val != reverse.val) isPalindrome = false;
      head = head.next;
      reverse = reverse.next;
    }
    return isPalindrome;
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

  private ListNode reverse(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;

    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    return prev;
  }
}
