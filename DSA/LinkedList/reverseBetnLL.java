package LinkedList;

public class reverseBetnLL {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        dummy.next = head;

        for (int i = 0; i < left; i++) {
            prev = prev.next;
        }

        ListNode curent = prev.next;
        

        for (int i = 0; i < right - left; i++) {
            ListNode ptr = prev.next;
            prev.next = curent.next;
            curent.next = curent.next.next;
            prev.next.next = ptr;
        }
        
        return dummy.next;
    }
}
