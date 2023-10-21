package Strivers.LinkedList;

public class OddEvenLL {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;

        while (odd != null && odd.next != null && odd.next.next != null && even.next.next != null && even != null
                && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
        }
        odd.next = temp;
        return head;
    }
}
