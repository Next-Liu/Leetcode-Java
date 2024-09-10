import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class TestDeque {
    public static void main(String[] args) {
        Deque<Integer> linkedlist = new LinkedList<>();
        linkedlist.addFirst(1);
        linkedlist.addFirst(2);
        linkedlist.addLast(3);
        linkedlist.addLast(4);
        for (Integer integer : linkedlist) {
            System.out.println("integer = " + integer);
        }
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addLast(3);
        arrayDeque.addLast(4);
        for (Integer integer : arrayDeque) {
            System.out.println("integer = " + integer);
        }
        Hashtable<String, String> hashtable = new Hashtable<>();
    }
}
