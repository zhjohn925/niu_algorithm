// Node in LinkedList has next pointer, rand pointer, and value
// next points to next Node, rand points to null or another Node in the list

// This function duplicates this given LinkedList, returns head of the new LinkedList.

public static Node copyLinkedList(Node head) {
  HashMap<Node, Node> map = new HashMap<Node, Node>();
  Node cur = head;
  // loop thru the given Linked list, each loop creates a new Node
  // with the same value, and map to each other. 
  //  n0  -> n0'
  //  n1  -> n1'
  //  n2  -> n2'
  while (cur != null) {
    map.put(cur, new Node(cur.value));
    cur = cur.next;
  }
  cur = head;
  // loop thru the given Linked list again, each loop finds
  // the new node's next and rand. 
  // map.get(cur) is new node
  // map.get(cur.next) is new node's next
  while (cur != null) {
    map.get(cur).next = map.get(cur.next);
    map.get(cur).rand = map.get(cur.rand);
    cur = cur.next;
  }
  return map.get(head);
}
