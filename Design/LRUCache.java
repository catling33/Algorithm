package Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // capacity
    int capacity;

    // index layer : hashmap to store key and reference to node
    Map<Integer, Node> indexMap = new HashMap<>();

    // data layer : doubly linked list
    Node head;
    Node tail;

    // node class to store key and value pair
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        // set capacity
        this.capacity = capacity;
    }

    public int get(int key) {
        // search for corresponding node in hashmap
        // case 1: not found
        if (!indexMap.containsKey(key)) {
            return -1;
        }
        // case 2: found -> put to head
        Node cur = indexMap.get(key);
        if (cur.prev != null) {
            cur.prev.next = cur.next;
            cur.next = head;
            head = cur;
        }
        return cur.value;
    }

    public void put(int key, int value) {
        // search for corresponding node
        // case 1: found -> update, put to head
        if (indexMap.containsKey(key)) {
            Node cur = indexMap.get(key);
            cur.prev.next = cur.next;
            cur.next = head;
            head = cur;
            cur.value = value;
            return;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
        indexMap.put(key, newNode);

        // case 3: not found, full -> remove old node at tail, add new node
        if (indexMap.size() > capacity) {
            indexMap.remove(tail.key);
            tail.prev = tail;
            tail.next = null;
            Node cur = new Node(key, value);
            cur.next = head;
            head = cur;
            indexMap.put(key, cur);
        }

    }

}
