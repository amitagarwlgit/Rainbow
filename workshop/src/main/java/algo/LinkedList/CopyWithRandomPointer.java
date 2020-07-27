package algo.LinkedList;

public class CopyWithRandomPointer {

  public Node copyRandomList(Node head) {

    if (head == null) return null;
    if (head.next == null) {
      return new Node(head.val);
    }

    Node copied = new Node(head.val);
    copied.next = (head.next == null) ? null : new Node(head.next.val);
    copied.random = (head.random == null) ? null : new Node(head.random.val);

    Node copiedPointer = copied;
    head = head.next;

    while (head != null) {
      Node temp = find(copied, head.val);
      temp.next = (head.next == null) ? null : find(copied, head.next.val);
      temp.random = (head.random == null) ? null : find(copied, head.random.val);
      copiedPointer.next = temp;
      head = head.next;
      copiedPointer = copiedPointer.next;
    }
    return copied;
  }

  private Node find(Node result, int val) {
    while (result != null) {
      if (result.val == val) return result;
      if (result.random != null && result.random.val == val) {
        return result.random;
      }
      result = result.next;
    }
    return new Node(val);
  }
}

class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}
