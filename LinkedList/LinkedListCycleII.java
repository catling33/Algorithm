package LinkedList;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        // sanity check
        if (head == null || head.next == null) {
            return null;
        }
        // find first intersection
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // if fast reaches the end, there is no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // there is a cycle:
        // start from head and the first intersection -> pointers will meet at the entrance
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
