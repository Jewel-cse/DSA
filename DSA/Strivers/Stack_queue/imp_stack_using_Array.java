package Strivers.Stack_queue;

public class imp_stack_using_Array {
    public static void main(String[] args) {
        Stak st = new Stak();
        st.push(0);
        st.push(2);
        st.push(3);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(9);
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(st.size());
    }
}
