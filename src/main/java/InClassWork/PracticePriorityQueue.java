package InClassWork;

import java.util.PriorityQueue;

public class PracticePriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.offer(5);
        pq.offer(3);
        pq.offer(2);
        pq.offer(4);
        pq.offer(1);
        pq.offer(9);

        System.out.println("Elements in ascending order: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
            System.out.println(pq.peek());

        }
    }
}
