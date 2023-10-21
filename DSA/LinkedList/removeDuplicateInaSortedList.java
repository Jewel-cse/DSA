package LinkedList;

import java.util.HashMap;

import String.largeString;
import Strivers.nextParmutation;

public class removeDuplicateInaSortedList {
    // problem 1
    public ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            if (temp.value == temp.next.value) {
                if (temp.next.next != null)
                    temp.next = temp.next.next;
                else
                    temp.next = null;

            } else
                temp = temp.next;
        }
        return head;
    }

    //problem 2
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode run = head;
        ListNode temp = new ListNode();
        ListNode ans = temp;
        int flag = 0;
        while (run.next != null) {
            if (run.next.value != run.value) {
                if (flag == 0) {
                    temp.next = run;
                    temp = temp.next;
                    run = run.next;

                } else {
                    run = run.next;
                    flag = 0;
                }
            } else {
                run = run.next;
                flag = 1;
            }
        }
        if (flag == 0) {
            temp.next = run;
            temp = temp.next;
        }
        else {
            temp.next = null;
        }
        return ans.next;
    }

}
