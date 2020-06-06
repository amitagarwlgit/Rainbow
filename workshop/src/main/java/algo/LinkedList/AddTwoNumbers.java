package algo.LinkedList;

import algo.LinkedList.model.ListNode;

import java.util.List;

// Input: (2 -> 4 -> 3) +
//        (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation:     342
//                  465
//                  807

// 0 + 37 = 37
//       0
//  7 -> 3
// = 7 -> 3
//

public class AddTwoNumbers {

  public ListNode addTwoNumbersConvert(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    return getNode(getNum(l1) + getNum(l2));
  }

  public int getNum(ListNode l) {
    int sum = 0;
    int i = 0;
    while (l != null) {
      sum += l.val * Math.pow(10, i);
      l = l.next;
      i++;
    }
    return sum;
  }

  public ListNode getNode(int n) {
    if (n < 10) return new ListNode(n);
    ListNode result = new ListNode(n % 10);
    ListNode curr = result;
    int number = n / 10;
    while (number > 0) {
      curr.next = new ListNode(number % 10);
      curr = curr.next;
      number /= 10;
    }
    return result;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode curr = l1;
    int buffer = 0;

    while (curr != null || l2 != null) {

      int sum = ((curr == null) ? 0 : curr.val) + ((l2 == null) ? 0 : l2.val) + buffer;
      buffer = (sum > 9) ? sum / 10 : 0;
      sum = (sum > 9) ? sum % 10 : sum;
      curr.val = sum;

      if (curr.next == null && l2.next != null) {
        curr.next = new ListNode(0);
      }

      if (l2.next == null && curr.next != null) {
        l2.next = new ListNode(0);
      }

      if (curr.next == null && l2.next == null && buffer != 0) {
        curr.next = new ListNode(buffer);
        break;
      }

      l2 = l2.next;
      curr = curr.next;
    }

    return l1;
  }
}
