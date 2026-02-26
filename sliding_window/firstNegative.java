import java.util.*;

public class firstNegative {

    // Brute Force Approach O(n*k)
    //tc: O(n*k) sc: O(1)
    //sc: O(n/k) for result list
    public static List<Integer> firstNegativeBruteForce(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i <= n - k; i++) {
            int firstNeg = 0;
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    firstNeg = arr[j];
                    break;
                }
            }
            result.add(firstNeg);
        }
        return result;
    }

    // Queue / Deque Approach O(n)
    //tc: O(n) sc: O(k) for deque + O(n/k) for result list
    //sc: O(k) for deque + O(n/k) for result list
    public static List<Integer> firstNegativeQueue(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>(); // store indices of negatives
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) dq.addLast(i);
        }
        result.add(dq.isEmpty() ? 0 : arr[dq.peekFirst()]);
        for (int i = k; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();

            // add new negative number index
            if (arr[i] < 0) dq.addLast(i);

            // store result
            result.add(dq.isEmpty() ? 0 : arr[dq.peekFirst()]);
        }
        return result;
    }

    // Sliding Window Optimized Approach O(n)
    //t: O(n) 
    // sc: O(1) for index tracking + O(n/k) for result list
    public static List<Integer> firstNegativeSlidingWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        
        int n = arr.length;
        int firstNegIndex = -1; // track index of first negative in current window  
        for (int i = 0; i < n; i++) {
            // If current element is negative and is within the current window, update firstNegIndex
            if (arr[i] < 0) {
                firstNegIndex = i;
            }

            // Once we have processed the first k elements, start adding results
            if (i >= k - 1) {
                // Check if the first negative index is still within the current window
                if (firstNegIndex != -1 && firstNegIndex <= i - k + 1) {
                    result.add(arr[firstNegIndex]);
                } else {
                    result.add(0); // No negative number in the current window
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;

        System.out.println("Brute Force Approach: " + firstNegativeBruteForce(arr, k));
        System.out.println("Queue/Deque Approach: " + firstNegativeQueue(arr, k));
        System.out.println("Sliding Window Optimized: " + firstNegativeSlidingWindow(arr, k));
    }
}