import java.util.*;

public class rotateArray {

    // Brute Force
    // Reminder: "Shift one step, repeat k times"
    static void brute(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        for(int i = 0; i < k; i++) {
            int last = nums[n - 1];

            for(int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }

            nums[0] = last;
        }
    }

    // Extra Array
    // Reminder: "Place element at (i + k) % n"
    static void extraArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];

        for(int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        for(int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // Optimal (Reversal Algorithm)
    // Reminder: "Reverse all → reverse first k → reverse rest"
    static void optimal(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {1,2,3,4,5,6,7};
        int[] arr3 = {1,2,3,4,5,6,7};
        int k = 3;

        brute(arr1, k);
        extraArray(arr2, k);
        optimal(arr3, k);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}
// Brute → “Shift k times”
// Extra → “(i + k) % n”
// Optimal → “Reverse 3 times”

// ⏱ Complexity

// Brute → O(nk)
// Extra → O(n) time, O(n) space
// Optimal → O(n) time, O(1) space