package com.jay.algorithms.stack;

public class ArrayStack {

    private String[] items;

    private int count;

    private int n;

    public ArrayStack(int n) {
        items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String val) {
        if (count == n) {
            resize();
        }
        items[count] = val;
        ++count;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String tmp = items[count - 1];
        --count;
        return tmp;
    }

    private void resize() {
        System.out.println("resize " + n * 2);
        var resizedItems = new String[n * 2];
        System.arraycopy(items, 0, resizedItems, 0, n);
        items = resizedItems;
        n = n * 2;
    }

    public void printAll() {
        for (var s : items) {
            System.out.print(s + "->");
        }
    }

    public static void main(String[] args) {
        var stack = new ArrayStack(2);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        stack.printAll();
    }
}
