package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // sanity check
        if (head == null) {
            return null;
        }
        // hashmap to store <old node, new node>
        Map<Node, Node> copyMap = new HashMap<>();
        // initialize : copy head as newHead, add to hashmap
        Node newHead = new Node(head.val);
        copyMap.put(head, newHead);
        // iterate through linked list
        // copy oldNode.next
        // link newNode to newNode.next
        // copy oldNode.random
        // linke newNode to newNode.random
        while (head != null) {
            if (head.next != null) {
                if (!copyMap.containsKey(head.next)) {
                    copyMap.put(head.next, new Node(head.next.val));
                }
                copyMap.get(head).next = copyMap.get(head.next);
            }
            if (head.random != null) {
                if (!copyMap.containsKey(head.random)) {
                    copyMap.put(head.random, new Node(head.random.val));
                }
                copyMap.get(head).random = copyMap.get(head.random);
            }
            head = head.next;
        }
        // return newHead
        return newHead;
    }
}
