package Strivers.Stack_queue;
public class Stak {
    int size;
    int top;
    int[] arr;

    //constructor
    Stak() {
        top = -1;
        size = 100;
        arr = new int[size];
        
    }
    // push method : insert top position
    public void push(int val) {
        arr[++top] = val;

    }
    //pop method: top return and delete
    public int pop() {
        int x = arr[top];
        top--;
        return x;
    }
    // top index koto
    public int top() {
        return arr[top];
    }
    //stack size
    public int size() {
        return top + 1;
    }
}
