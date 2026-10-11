
import java.util.*;

class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
    }

    public int pop() {
        Queue<Integer> active = q1.isEmpty() ? q2 : q1;
        Queue<Integer> temp = q1.isEmpty() ? q1 : q2;

        int n = active.size();

        for (int i = 0; i < n - 1; i++) {
            temp.offer(active.poll());
        }

        return active.poll();
    }

    public int top() {
        Queue<Integer> active = q1.isEmpty() ? q2 : q1;
        Queue<Integer> temp = q1.isEmpty() ? q1 : q2;

        int n = active.size();

        for (int i = 0; i < n - 1; i++) {
            temp.offer(active.poll());
        }

        int value = active.poll();
        temp.offer(value);

        return value;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
