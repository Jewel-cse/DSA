public class main_queue {
    public static void main(String[] args) {
        /*
         * 
         Queue_arr q = new Queue_arr(5);
         
         q.enqueue(0);
         q.enqueue(2);
         q.enqueue(4);
         q.enqueue(6);
         
         q.displayQueue();
         q.dequeue();
         q.displayQueue();
         
         * 
         */
        /*
         * 
         im_stack_using_Q stak = new im_stack_using_Q();
         stak.push(0);
         stak.push(2);
         stak.push(3);
         stak.push(4);
         stak.push(6);
         //System.out.println(stak.display());
         stak.display();
         * 
         */

        imp_Q_LL q = new imp_Q_LL();
        q.enqueue(0);
        q.enqueue(02);
        q.enqueue(03);
        q.enqueue(04);
        q.enqueue(07);
        q.enqueue(03);
        q.display();
        System.out.println(q.top());
        q.deque();
        q.deque();
        System.out.println(q.top());
        q.display();

    }
}
