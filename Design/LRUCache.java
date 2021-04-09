package Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // capactiy
    int capacity;

    // index layer : hashmap
    Map<Integer, Node> indexMap;

    // data layer : doubly linked list
    Node head;
    Node tail;

    // node class
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        indexMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = indexMap.get(key);
        // if not found
        if (node == null) {
            return -1;
        }
        // remove node
        remove(node);
        // append node
        append(node);
        // return node's value
        return node.val;
    }

    public void put(int key, int value) {
        Node node = null;
        // if exists
        if (indexMap.containsKey(key)) {
            node = indexMap.get(key);
            node.val = value;
            remove(node);
        } else if (indexMap.size() < capacity) {
            node = new Node(key, value);
        } else { // if full
            node = tail;
            remove(node);
            node.key = key;
            node.val = value;
        }
        append(node);
    }

    // remove a node
    private Node remove(Node node) {
        // remove from indexMap
        indexMap.remove(node.key);
        // link prev to next
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        // link next to prev
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        // if node is head
        if (node == head) {
            head = head.next;
        }
        // if node is tail
        if (node == tail) {
            tail = tail.prev;
        }
        // reset node's prev and next
        node.next = node.prev = null;
        return node;
    }

    // append a node
    private void append(Node node) {
        // put into indexMap
        indexMap.put(node.key, node);
        // head is null
        if (head == null) {
            head = tail = node;
        } else { // head is node null
            node.next = head;
            head.prev = node;
            head = node;
        }
        return;
    }

    public static void main(String[] args) {
        LRUCache sol = new LRUCache(2);
        sol.put(1,1);
        sol.put(2,2);
        System.out.println(sol.get(1)); // 1
        sol.put(3,3);
        System.out.println(sol.get(2)); // -1
        sol.put(4,4);
        System.out.println(sol.get(1));
        System.out.println(sol.get(3));
        System.out.println(sol.get(4));
    }
}
