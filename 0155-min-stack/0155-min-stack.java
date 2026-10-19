
import java.util.*;

class MinStack {
    Stack<Long> s1;
    long min = Long.MAX_VALUE;

    public MinStack() {
        s1 = new Stack<>();
    }

    public void push(int value) {
        long val = value;

        if (s1.isEmpty()) {
            min = val;
            s1.push(val);
        }
        else if (val < min) {
            long newVal = 2 * val - min;
            s1.push(newVal);
            min = val;
        }
        else {
            s1.push(val);
        }
    }

    public void pop() {
        if (s1.peek() < min) {
            min = 2 * min - s1.pop();
        }
        else {
            s1.pop();
        }

        if (s1.isEmpty()) {
            min = Long.MAX_VALUE;
        }
    }

    public int top() {
        if (s1.peek() < min) {
            return (int) min;
        }
        return s1.peek().intValue();
    }

    public int getMin() {
        return (int) min;
    }
}
