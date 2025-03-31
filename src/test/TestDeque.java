package test;

import java.util.Deque;
import java.util.LinkedList;

public class TestDeque {
    public static void main(String[] args) {
        LinkedList<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque.peek());
        System.out.println(deque.poll());
        System.out.println(deque.peek());
        System.out.println(deque.pop());
        System.out.println(deque.peek());

    }
}
