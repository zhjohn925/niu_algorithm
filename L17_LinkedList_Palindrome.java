// Need N extra space
// Use Stack to reverse the whole linked-list, then pop to compare
public static boolean isPalindrome1(Node head) {
  Stack<Node> stack = new Stack<Node>();
  Node cur = head;
  while (cur != null) {
    stack.push(cur);
    cur = cur.next;
  }
  while (head != null) {
    if (head.value != stack.pop().value) {
      return false;
    }
    head = head.next;
  }
  return true;
}

// 00:51:16

// This method needs N/2 extra space
// Push the right half to Stack 
// Compare the left half with the right half in Stack
public static boolean isPalindrome2 (Node head) {
  if (head == null || head.next == null) {
    return true;
  }
  Node right = head.next;
  Node cur = head;
  // locate the right half linked list
  while (cur.next != null && cur.next.next != null) {
    right = right.next;
    cur = cur.next.next;
  }
  // push the right half linked list to Stack 
  Stack<Node> stack = new Stack<Node>();
  while (right != null) {
    stack.push(right);
    right = right.next;
  }
  // compare the left half with the right half in Stack
  while (!stack.isEmpty()) {
    if (head.value != stack.pop().value) {
      return false;
    }
    head = head.next;
  }
  return true;
}


// Need O(1) extra space, no extra space 
// - Divide the linked-list into the left half and right half
// - Reverse the right half
// - Compare the left half with the reversed right half
// - Restore the right half
public static boolean isPalindrome3 (Node head) {
  if (head == null || head.next == null) {
    return true;
  }
  Node n1 = head;
  Node n2 = head;
  while (n2.next != null && n2.next.next != null) { // find mid node
    n1 = n1.next;       // n1 -> mid
    n2 = n2.next.next;  // n2 -> end
  }
  n2 = n1.next;      // n2 -> right part first node
  n1.next = null;    // mid.next -> null
    Node n3 = null;
    while (n2 != null) {   // reverse right part
      n3 = n2.next;    // n3 -> save next node
      n2.next = n1;    // next of right node convert
      n1 = n2;         // n1 move
      n2 = n3;         // n2 move
    }
    n3 = n1;   // n3 -> save last node
    n2 = head; // n2 -> left first node
    boolean res = true;
    while (n1 != null && n2 != null) {    // check palindrome
      if (n1.value != n2.value) {
        res = false;
        break;
      }
      n1 = n1.next;    // left to mid
      n2 = n2.next;    // right to mid
    }
    n1 = n3.next;
    n3.next = null;
    while (n1 != null) {  // restore the right part
      n2 = n1.next;
      n1.next = n3;
      n3 = n1;
      n1 = n2;
    }
  return true;
}
