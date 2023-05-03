package com.shivamkchoudhary;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueClass {
    public static void main(String[] args) {
        Queue<String> aq = new PriorityQueue<>();
        aq.add("Shivam");
        aq.add("Kumar");
        aq.add("Choudhary");
        aq.add("Shivam");
        System.out.println(aq);

        //using linked list
        Deque<String> dq = new LinkedList<>();

        dq.add("Shivam");
        dq.add("Kumar");
        dq.add("Choudhary");
        dq.addFirst("Mr.");

        System.out.println(dq);
    }
}
