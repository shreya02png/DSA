import java.util.*;
public class NextGreaterElement {
    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();

            stack.push(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10};
        int[] ans = nextGreater(arr);
        for (int x : ans)
            System.out.print(x + " ");
    }
}


// tc: O(n) - We traverse the array once.
// sc: O(n) - In worst case when the array is in decreasing order, all elements will be stored in the stack.


// I use a monotonic decreasing stack and traverse the array from right to left.
// For each element, I pop all smaller or equal elements from the stack because they cannot be the next greater element for the current value.
// If the stack becomes empty, it means there is no greater element on the right, so I store -1.
// Otherwise, the top of the stack is the next greater element. Then I push the current element onto the stack so it can help resolve elements on its left.
// Since every element is pushed and popped at most once, the overall time complexity is O(n).
// The space complexity is O(n) in the worst case when the array is in strictly decreasing order, as all elements will be stored in the stack.