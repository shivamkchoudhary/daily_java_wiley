package com.shivamkchoudhary;

public class QueueClass {
    int SIZE = 5;
    int[] items = new int[SIZE];
    int front, rear;

    public QueueClass() {
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == -1) {
            return true;
        } else {
            return false;
        }
    }

    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Deleted " + element);
            return (element);
        }
    }

    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front index: " + front);
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++) {
                System.out.print(items[i] + " ");
            }
            System.out.println("Rear index: " + rear);
        }
    }

    public static void main(String[] args) {
        QueueClass q = new QueueClass();
        q.deQueue();
        for (int i = 1; i <= 5; i++) {
            q.enQueue(i);
        }
        q.enQueue(6);
        q.display();
        q.deQueue();
        q.display();
    }
}
