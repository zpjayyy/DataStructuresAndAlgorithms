package com.jay.algorithms.linkedlist;

import java.util.stream.IntStream;

public class SinglyLinkedList {

    private ListNode head;

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void insertToTail(int value) {
        if (head == null) {
            head = new ListNode(value);
        } else {
            var cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(value, null);
        }
    }

    public void insertToHead(ListNode head, ListNode node) {
        var next = head.next;
        head.next = node;
        node.next = next;
    }

    public boolean isPalindrome() {
        if (head.next == null) {
            return true;
        }

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow.next == null) {
            return head.val == head.next.val;
        }

        var reverseHead = headReverse(slow);

        boolean isPalindrome = true;

        var right = fast == null ? slow : slow.next;
        var left = reverseHead.next;
        while (right != null && left != null) {
            if (right.val != left.val) {
                isPalindrome = false;
                break;
            }
            right = right.next;
            left = left.next;
        }

        return isPalindrome;
    }

    private ListNode headReverse(ListNode endNode) {
        var newHead = new ListNode(-999);
        var cur = head;
        while (cur != null && cur != endNode) {
            var temp = cur.next;
            insertToHead(newHead, cur);
            cur = temp;
        }
        return newHead;
    }

    private void printAll() {
        var cur = head;
        while (cur.next != null) {
            System.out.print(" -> " + cur.next.val);
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertToTail(1);
        list.insertToTail(1);
//        list.insertToTail(2);
//        list.insertToTail(1);
        list.printAll();
        System.out.println(list.isPalindrome());
    }
}
