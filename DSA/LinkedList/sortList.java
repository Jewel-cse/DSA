package LinkedList;

public class sortList {
    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode left = sort(head);
        ListNode right = sort(slow);

        return merge(left, right);
    }

    // merge..................
    public ListNode merge(ListNode l1, ListNode l2) {
        
        ListNode sorted = new ListNode(0);
        ListNode current = sorted;
        while (l1 != null && l2 != null) {
            if ( l1.value < l2.value) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
            l1 = l1.next;
        }
        if (l2 != null) {
            current.next = l2;
            l2 = l2.next;
        }
        return sorted.next;

    }
}
