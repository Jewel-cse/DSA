class Stack_using_LL {

    // stack node desgin .......................
    private class StackNode {
        int val;
        StackNode next;

        StackNode(int val) {
            this.val = val;
            next = null;
        }
    }

    //initialization of object..................
    StackNode top;
    int size;

    Stack_using_LL() {
        this.top = null;
        size = 0;
    }

    //some method have to implement

    //push : insert first of ll
    public void push(int val) {
        StackNode node = new StackNode(val);
        node.next = top;
        top = node;
        size++;
    }

    //pop : delete first of ll
    public int pop() {
        if (top == null) {
            System.out.println("Stack overflow");
        }
        int topVal = top.val;
        top = top.next;
        size--;
        return topVal;
    }

    //current size of stack
    public int stackSize() {
        return size;
    }
    //check empy
    public boolean isEmpty() {
        return top == null;
    }

    //print stack
    public void printStack() {
        StackNode temp = top;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}