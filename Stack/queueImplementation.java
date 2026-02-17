import java.util.*;

class MyStackOneQueue {
// Approach 1: One Queue
    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.offer(x);

        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    public void pop() {
        if (!q.isEmpty())
            q.poll();
    }

    public int top() {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
// Approach 2: Two Queues
class MyStackTwoQueues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.offer(x);

        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        // swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public void pop() {
        if (!q1.isEmpty())
            q1.poll();
    }

    public int top() {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

public class queueImplementation {

    public static void main(String[] args) {
        System.out.println("Using One Queue:");
        MyStackOneQueue s1 = new MyStackOneQueue();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1.top());
        s1.pop();
        System.out.println(s1.top());
        System.out.println("\nUsing Two Queues:");
        MyStackTwoQueues s2 = new MyStackTwoQueues();
        s2.push(10);
        s2.push(20);
        s2.push(30);
        System.out.println(s2.top());
        s2.pop();
        System.out.println(s2.top());
    }
}
