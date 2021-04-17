package Heap;

public class MinHeap {
    private int[] array;
    private int size;

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    // zuoyuan
    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public MinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity can not be <= 0");
        }
        array = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    // TODO
    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
        }
    }

    // ziyang
    private void percolateDown(int index) {
    }

    public int peek() {
    }

    public int poll() {
    }

    public void offer(int ele) {
    }

    public int update(int index, int ele) {
    }

    private void swap(int l, in r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }

}
