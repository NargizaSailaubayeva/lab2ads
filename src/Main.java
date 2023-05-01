/**
 * check MyArrayList and MyLinkedList if it works
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /** MyArrayList<Integer> nan = new MyArrayList<>(); //check MyArrayList
        nan.add(3);
        nan.add(56);
        nan.add(55);
        nan.add(44);
        nan.add(33);
        nan.remove(3);
        nan.removed(3);
        nan.sort();
        nan.add(66);
        //nan.clear();
        //nan.sortsubl();
        System.out.println(nan.size());
        System.out.println(nan.get(3));
        System.out.println(nan.indexOf(3));
        System.out.println(nan.lastIndexOf(2));
        System.out.println(nan.contains(6));
        for( int i=0; i<nan.size(); i++){
            System.out.print(nan.get(i) + " ");
        } */
        /**
        MyLinkedList link = new MyLinkedList(); //check MyLinkedList
        link.add(5);
        link.add(7);
        link.add(8);
        link.add(6);
        link.add(9,2);
        link.add(4,3);
        System.out.println(link.contains(7));
        System.out.println(link.indexOf(8));
        System.out.println(link.lastIndexOf(6));
        link.remove(8);
        link.removed(4);
        link.sort();
        link.clear();
        for (int i = 0; i<link.size(); i++){
            System.out.print(link.get(i) + " ");
        } */
        // check MyArrayListStack
        MyArrayListStack<Integer> stack = new MyArrayListStack<Integer>();
        stack.push(5);
        stack.push(9);
        Integer rty = stack.pop();
        System.out.println(stack.peek());
        System.out.println(rty);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        // check MyLinkedListQueue
        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<Integer>();
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        MyArrayListQueue<Integer> q = new MyArrayListQueue<>();
        q.enqueue(4);
        q.enqueue(8);
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
    }
}