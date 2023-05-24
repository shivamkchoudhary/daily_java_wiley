package com.shivamkchoudhary;

public class LinkdeListClass {

    private Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    void insertAtMiddle(int data, int position) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }
        else {
            Node temp = head;
            for(int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    void deleteAtEnd() {
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            Node temp = head;
            while(temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }
    void deleteAtBeginning() {
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            head = head.next;
        }
    }
    void deleteAtMiddle(int position) {
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            Node temp = head;
            for(int i = 0; i < position - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }
    void printList() {
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            Node temp = head;
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
    void sortList() {
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            Node temp = head;
            while(temp != null) {
                Node temp2 = temp.next;
                while(temp2 != null) {
                    if(temp.data > temp2.data) {
                        int tempData = temp.data;
                        temp.data = temp2.data;
                        temp2.data = tempData;
                    }
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkdeListClass list = new LinkdeListClass();

        //Assign the value
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        //Link the nodes
        list.head.next = second;
        second.next = third;

        //Print the list
        while (list.head != null) {
            System.out.println(list.head.data);
            list.head = list.head.next;
        }
    }

        //Insert at the end
        //Insert at the beginning
        //Insert at the middle
        //Delete at the end
        //Delete at the beginning
        //Delete at the middle
        //print the list
        //Search the list by key
        // Sort the list
        // Reverse the list

}
