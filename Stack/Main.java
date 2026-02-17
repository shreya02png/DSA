import java.util.*;

class SpecialStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public SpecialStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        stack.pop();
    }

    public int peek() {
        if (stack.isEmpty())
            return -1;

        return stack.peek();
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMin() {
        if (minStack.isEmpty())
            return -1;

        return minStack.peek();
    }
}

public class Main {
    public static void main(String[] args) {

        SpecialStack st = new SpecialStack();

        st.push(2);
        st.push(3);

        System.out.println(st.peek());    // 3

        st.pop();

        System.out.println(st.getMin());  // 2

        st.push(1);

        System.out.println(st.getMin());  // 1
    }
}






// We use two stacks:
//stack → stores all elements normally
// minStack → keeps track of minimum values
// When we push(x):
//   >>Push x into the normal stack.
//   <<If minStack is empty OR x is smaller than or equal to the current minimum, push x into minStack too.

// This way, minStack always stores the minimum element at its top.

// When we pop():
//   >>If the top of the normal stack equals the top of minStack, we remove from both.
//   >>Otherwise, we remove only from the normal stack.

// So at any moment, the top of minStack is the minimum element of the entire stack.