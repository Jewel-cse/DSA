package LinkedList;

public class main_LL {
    public static void main(String[] args) {
        LL list = new LL();
        /* list.insertFirst(23);
        list.insertFirst(0);
        list.insertFirst(93);
        list.insertLast(999999);
        list.insert(88, 3);
        list.display();
        System.out.println(list.deleteFirst() + " deleted");
        list.display();
        System.out.println(list.deleteLast() + " last node deleted");
        list.display();
        
        System.out.println(list.delete_(1) + " index deleted");
        list.display();
 */

        //insert node using loop
        for (int i = 0; i < 5; i++) {
            list.insert(i * 2, i);
        }
        list.display();
        

    }
}
