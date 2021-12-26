package credit.ex11;

import java.util.LinkedList;
import java.util.List;

/**
 * Реализуйте свой собственный стек (очередь) со стандартными функциями push() и pop(),
 * а так же с дополнительной функцией max() за O(1)
 */

public class MyStack<T> {

    private Node<T> first = null;
    private int size = 0;
    private int sizeMax = -1;
    private List lindeklistMax = new LinkedList();

    public static class Node<T> {

        private int data;
        private Node<T> next;

        public Node(int data) {
            this.data = data;
        }
    }

    public int size() {
        return size;
    }

    public void push(int data) {
        Node<T> newFirst = new Node<>(data);
        newFirst.next = first;
        first = newFirst;
        size++;
        addMax(data);
    }

    public int max() {
        if (sizeMax == -1) {
            throw new NullPointerException("MyStack is empty");
        }
        return (int) lindeklistMax.get(sizeMax);
    }

    private void addMax(int data) {
        if ((sizeMax == -1) || ((int) lindeklistMax.get(sizeMax) <= data)) {
            lindeklistMax.add(++sizeMax, data);
        }
    }

    private void delMax(int data) {
        if (sizeMax == -1) {
            throw new NullPointerException("MyStack is empty");
        } else {
            if (lindeklistMax.get(sizeMax).equals(data)) {
                lindeklistMax.remove(sizeMax--);
            }
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new NullPointerException("MyStack is empty");
        }
        Node<T> oldFirst = first;
        first = first.next;
        size--;
        delMax(oldFirst.data);
        return oldFirst.data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NullPointerException("MyStack is empty");
        }
        Node<T> oldFirst = first;
        return oldFirst.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}