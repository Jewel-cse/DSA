package LinkedList;

public class rightRotate {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        
        //count number of node
        ListNode curent = head;
        int totalNode = 1;
        while (curent.next != null) {
            totalNode++;
            curent = curent.next;
        }

        // expected node e reach kora
        int expectedNode = totalNode - (k % totalNode);
        curent.next = head;
        while (expectedNode-- > 0) {
            curent = curent.next;
        }
        // head assign and null add
        head = curent.next;
        curent.next = null;

        return head;
    }
}
