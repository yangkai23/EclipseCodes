package queue;

import java.util.NoSuchElementException;

public class QueueArray {
    private int[] queue;
    private int size;
    private int front;
    private int back;

    public QueueArray(int capacity) {
        this.queue = new int[capacity];
        back = front = size = 0;
    }

    public void add(int data) {
        if (size == queue.length - 1) {
            resizeArray();
            front = 0;
            back = size;
        }
        queue[back++] = data;
        size++;
        if (back > queue.length - 1) {
            back = 0;
        }


    }

    public int remove() {
        if (isEmpty()) throw new NoSuchElementException();
        int result = queue[front];
        queue[front++] = 0;
        size--;
        if (size() == 0) {
            front = back = 0;
        } else if (front == queue.length) front = 0;
        return result;
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return queue[front];
    }


    public void printQueue() {
        if (back >= front) {
            for (int i = front; i < back; i++)
                System.out.print(queue[i] + " ");
        } else {
            for (int i = front; i < queue.length; i++)
                System.out.print(queue[i] + " ");
            for (int i = 0; i < back; i++)
                System.out.print(queue[i] + " ");
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void resizeArray() {
        int[] newArray = new int[this.size * 2];
        System.arraycopy(queue, front, newArray, 0, queue.length - front);
        if (front > back) System.arraycopy(queue, 0, newArray, queue.length - front, back);
        queue = newArray;
    }
}
