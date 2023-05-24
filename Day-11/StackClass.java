package com.shivamkchoudhary;

public class StackClass {
    private int arr[];
    private int top;
    private int capacity;

    StackClass(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if(isFull()) {
            System.out.println("Stack is overflown, program is terminated.");
            System.exit(1);
        }
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty, program is terminated.");
            System.exit(1);
        }
        System.out.println("Removing " + peek());
        return arr[top--];
    }
    public int size() {
        return top + 1;
    }
    public Boolean isEmpty() {
        return top == -1;
    }
    public Boolean isFull() {
        return top == capacity - 1;
    }
    public void printStack() {
        for(int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int peek() {
        if(!isEmpty()) {
            return arr[top];
        } else {
            System.exit(1);
        }
        return -1;
    }

    public static void main(String[] args) {
        StackClass stack = new StackClass(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.printStack();

        stack.pop();
        stack.pop();

        stack.printStack();
    }
}
