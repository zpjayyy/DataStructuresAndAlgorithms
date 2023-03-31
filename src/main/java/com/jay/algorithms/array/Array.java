package com.jay.algorithms.array;

import java.util.Arrays;

public class Array {

    public int[] data;

    public int n;

    public int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int find(int index) {
        if (index < 0 || index > count) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > n) {
            return false;
        }

        if (count == n) {
            System.out.println("数组满了！！");
            return false;
        }

        for (int i = count; i < index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        count++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index > n) {
            return false;
        }

        if (index > count) {
            System.out.println("该位置没得值");
            return false;
        }

        for (int i = index; i < count; i++) {
            data[i] = data[i + 1];
        }
        count--;
        return true;
    }

    public void printAll() {
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.insert(3, 11);
        array.printAll();
    }
}
