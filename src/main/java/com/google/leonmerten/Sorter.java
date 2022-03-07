package com.google.leonmerten;

import java.util.Random;

class Sorter<T extends Comparable<? super T>> {
    private final Random RANDOM = new Random();

    void sort(T[] array) {
        sort(array, 0, array.length - 1, false);
    }

    private void sort(T[] array, int a, int b, boolean performance) {
        if (a >= b) return;

        int pivot = partition(array, a, b, performance);
        sort(array, a, pivot - 1, performance);
        sort(array, pivot + 1, b, performance);
    }

    private int partition(T[] array, int a, int b, boolean performance) {
        if(performance)
             swap(array,a+getPivot(a,b),b);
        T pivot = array[b];
        int i = (a - 1);
        for (int n = a; n <= b - 1; n++)
            if (array[n].compareTo(pivot) < 0) {
                i++;
                swap(array, i, n);
            }
        swap(array, i + 1, b);
        return (i + 1);
    }

    private void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private int getPivot(int a, int b) {
        return RANDOM.nextInt(b-a);
    }
}
