import java.util.*;

public class happyNumber {

    // Helper function
    public static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

    // Approach 1: Brute Force (with iteration limit)
    //tc: O(k * log(n)) where k is the iteration limit and log(n) is the number of digits in n
    //sc: O(1) as we are not using any extra space
    public static boolean isHappyBrute(int n) {
        int limit = 1000;
        while (n != 1 && limit-- > 0) {
            n = getNext(n);
        }
        return n == 1;
    }

    // Approach 2: HashSet
    //tc: O(k * log(n)) where k is the number of unique sums generated before a repeat or reaching 1, and log(n) is the number of digits in n
    //sc: O(k) where k is the number of unique sums generated before a repeat or reaching 1
    public static boolean isHappyHashSet(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getNext(n);
        }

        return true;
    }

    // Approach 3: Fast & Slow Pointer (Best)
    //tc: O(k * log(n)) where k is the number of unique sums generated before a repeat or reaching 1, and log(n) is the number of digits in n
    //sc: O(1) as we are not using any extra space
    public static boolean isHappyTwoPointer(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    public static void main(String[] args) {
        int n = 19;

        System.out.println("Brute Force: " + isHappyBrute(n));
        System.out.println("HashSet: " + isHappyHashSet(n));
        System.out.println("Two Pointer: " + isHappyTwoPointer(n));
    }
}


// This problem repeatedly replaces a number with the sum of squares of its digits.
// Eventually, the number either becomes 1 or falls into a cycle.
// So it becomes a cycle detection problem.
// I use Floyd’s cycle detection algorithm with slow and fast pointers.
// If fast reaches 1, the number is happy.
// If slow and fast meet before reaching 1,
// it means there is a cycle and the number is not happy.
// This gives O(log n) time and O(1) space complexity.