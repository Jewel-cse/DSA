package Strivers.LinkedList;

import java.util.HashSet;

public class leetcodeLL extends ListNode {

    public static void main(String[] args) {
        ListNode list = new ListNode();
        for (int i = 5; i >= 0; i--) {
            list.insertLast(i);
            //list2.insert(i, i);
        }
        list.display(list.head);

        sortList s = new sortList();
        list.display(s.sort(list.head));
        
        //ListNode list1 = new ListNode();
        //ListNode list2 = new ListNode();


        /*
        for (int i = 0; i < 5; i++) {
            list1.insert((i), i);
            //list2.insert(i, i);
        }


          for (int i = 0; i <= 5; i++) {
            list2.insert(i * 2, i);
            //list2.insert(i, i);
        }
        list.display(list.head);
        //list.display(reverse_list(head));
        
        System.out.println(middleNode(list.head).value);
        //System.out.println(size);
        list.display(removeNthFromEnd(list.head, 2));
        
        list1.display(list1.head);
        list2.display(list2.head);
        list1.display(mergeTwoLists(list1.head, list2.head)); */

        //list.display(addTwoNumbers(list.head, list1.head));
        /*
         
        ListNode resultNode = getIntersectionNode(list.head, list1.head);
        if (resultNode != null) {
            System.out.println(resultNode.value);
        }
         */
        

    }

    // revers linked list : leetcode - 206
    public static ListNode reverse_list(ListNode head) {
        ListNode p = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = p;
            p = head;
            head = next;
        }
        return p;
    }

    //find the middle of the linked list............. 
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) { //1st middle  && 2nd middle
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //remove nth node from the back of linked list -leetcode 19
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode fast = temp, slow = temp;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }

    //merge two sorted linked list
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode curentNode = temp;

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                curentNode.next = l1;
                l1 = l1.next;
            } else {
                curentNode.next = l2;
                l2 = l2.next;
            }
            curentNode = curentNode.next;
        }
        if (l1 != null) {
            curentNode.next = l1;
            l1 = l1.next;
        }
        if (l2 != null) {
            curentNode.next = l2;
            l2 = l2.next;
        }
        return temp.next;
    }

    //add two numbers reversly : leetcode 2
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode curentNode = temp;

        int digit = 0;
        while (l1 != null || l2 != null || digit != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;
            }
            sum += digit;
            digit = sum / 10;
            ListNode node = new ListNode(sum % 10);
            curentNode.next = node;
            curentNode = curentNode.next;
        }

        return temp.next;
    }

    //intersection of two linked list
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs = new HashSet<>();

        while (headA != null) {
            hs.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (hs.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        System.out.println(hs);
        return null;
    }

    //linked list cycle check : leet 141
    public static Boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {     // colision detect means cycle ase>>
                return true;
            }
        }
        return false;
    }

    //starting node of cycle : leet=142
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {  // colision detect 
                slow = head; // colision point and head theke 1 step kore gele 
                while (slow != fast) { //jekhane abar clision hobe oiTai starting point
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    } 




    //check palindrome of given linked list.: leet 234
    // find middle, after middle reverse it to last then dummy(first) and middle check ++
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse_list(slow);
        ListNode dummy = head;
        while (slow != null) {
            if (slow != dummy) {
                return false;
            }
            slow = slow.next;
            dummy = dummy.next;
        }
        return true;
    }


    
}


