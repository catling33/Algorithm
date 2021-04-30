package LinkedList;

public class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    // dummy -> 0 -> 1 -> 2 -> 3 -> null  index = 2
    // head
    //                   cur


    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode prev = head;
        ListNode cur = head.next;
        for (int i = 0; i < index; i++) {
            prev = cur;
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        prev.next = newNode;
        newNode.next = cur;
    }
    // dummy -> 0 -> 1 -> 2 -> 3 -> null  index = 2
    // head
    //             prev  cur

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode prev = head;
        ListNode cur = head.next;
        for (int i = 0; i < index; i++) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        cur.next = null;
    }
    // dummy -> 0 -> 1 -> 2 -> 3 -> null  index = 2
    // head
    //             prev  cur
}
