package LinkedList;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // sanity check
        if (l1 == null && l2 == null) {
            return null;
        }
        // dummy linked list to append the result
        ListNode dummy = null;
        ListNode head = dummy;
        // reverse l1 and l2
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        // record carry
        int carry = 0;
        // iterate:
        // calculate sum
        // update carry
        // append digit
        while (c1 != null || c2 != null || carry != 0) {
            if (c1 != null) {
                carry += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                carry += c2.val;
                c2 = c2.next;
            }
            int digit = carry % 10;
            carry /= 10;

            // append digit to head
            ListNode newNode = new ListNode(digit);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
    // reverse linked list
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while(head != null) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }
}
