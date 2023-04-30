package queue;

import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args) {
        QueueArray queueArray=new QueueArray(5);
        queueArray.add(2);
        queueArray.add(3);
        queueArray.add(6);
        queueArray.add(4);
        queueArray.add(5);
        queueArray.printQueue();
        queueArray.remove();
        System.out.println();
        queueArray.printQueue();
    }
}
