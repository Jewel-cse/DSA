package Strivers.LinkedList;
    //create node design

public class DeleteNodeinLL {

    //
    static Node insertNode(Node head, int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    static Node getNode(Node head, int value) {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node.value != value) {
            node = node.next;
        }
        return node;
    }

    // delete 
    static void deleteNode(Node node) {
        if (node == null)
            return;

        node.value = node.next.value;
        node.next = node.next.next;

    }

    static void printList(Node head) {
        if (head == null)
            return;
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.value);
    }

    public static void main(String args[]) {
        Node head = null;
        //inserting node
        head = insertNode(head, 1);
        head = insertNode(head, 4);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        //printing given list
        System.out.println("Given Linked List: ");
        printList(head);
        Node t = getNode(head, 4);
        //delete node
        deleteNode(t);
        //list after deletion operation
        System.out.println("Linked List after deletion: ");
        printList(head);
    }

}

