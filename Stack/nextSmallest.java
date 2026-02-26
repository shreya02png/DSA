import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class nextSmallest {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        // traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(arr[i]);
        }

        // reverse the result list
        Collections.reverse(result);

        return result;
    }
    public static void main(String[] args) {
        nextSmallest obj = new nextSmallest();
        int[] arr = {4, 5, 2, 10};
        ArrayList<Integer> ans = obj.nextLargerElement(arr);
        for (int x : ans)
            System.out.print(x + " ");
    }
}

//tc: O(n) - We traverse the array once.
//sc: O(n) - In worst case when the array is in decreasing order, all elements will be stored in the stack.

//we use a monotonic decreasing stack and traverse the array from right to left.
// For each element, we pop all smaller or equal elements from the stack because they cannot be the next greater element for the current value.
// If the stack becomes empty, it means there is no greater element on the right, so we store -1.
// Otherwise, the top of the stack is the next greater element. Then we push the current element onto the stack so it can help resolve elements on its left.
// Since every element is pushed and popped at most once, the overall time complexity is O(n).

