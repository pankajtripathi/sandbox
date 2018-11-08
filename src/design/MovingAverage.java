package design;

import java.util.LinkedList;
import java.util.Queue;

/*
*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

* */
public class MovingAverage {
    Queue<Integer> queue;
    int size;
    double avg;

    public MovingAverage(int size) {
        this.queue = new LinkedList();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() < this.size) {
            queue.add(val);
            return calculateAvg();
        } else {
            queue.poll();
            queue.add(val);
            return calculateAvg();
        }
    }

    private double calculateAvg() {
        double sum = 0;
        int qSize = queue.size();
        for (int num : queue)
            sum += num;
        return sum / qSize;
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}




