package com.jay.algorithms.linkedlist;

import java.util.Objects;

public class LinkedList<T> {

    private Node<T> head;

    private static class Node<T> {

        public T value;

        public Node prev;

        public Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private void insertToTail(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            var newNode = new Node<>(value);
            cur.next = newNode;
            newNode.prev = cur;
        }
    }

    private void printAll() {
        System.out.print(head.value);
        var cur = head;
        while (cur.next != null) {
            System.out.print(" -> " + cur.next.value);
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 判断回文
     *
     * @return
     */
    private boolean palindrome() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        boolean isPalindrome = true;

        Node prevNode = slow;
        Node nextNode = slow;
        while (prevNode != null && prevNode.prev != null) {
            prevNode = prevNode.prev;
            nextNode = nextNode.next;

            if (nextNode == null) {
                break;
            }

            if (!Objects.equals(prevNode.value, nextNode.value)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }


    private static LinkedList initLinkList(String text) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < text.length(); i++) {
            var value = text.charAt(i);
            list.insertToTail(value);
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList list = initLinkList("aaaa");
        list.printAll();
        System.out.println(list.palindrome());
        list.printAll();
    }
}
