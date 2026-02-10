import java.util.*;

public class majorityElement {

    // Brute Force
    // TC: O(n^2)
    // SC: O(1)

    public static int majorityBrute(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    // HashMap Approach
    // TC: O(n)
    // SC: O(n)

    public static int majorityHashMap(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }

    // Sorting Approach

    // TC: O(n log n)
    // SC: O(1) or O(n)

    public static int majoritySorting(int[] nums) {

        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    //Moore's Voting Algorithm (Optimal )

    // TC: O(n)
    // SC: O(1)

    public static int majorityMoore(int[] nums) {

        int count = 0;
        int candidate = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };

        System.out.println("Brute Force: " + majorityBrute(nums));
        System.out.println("HashMap: " + majorityHashMap(nums));
        System.out.println("Sorting: " + majoritySorting(nums));
        System.out.println("Moore Voting (Optimal): " + majorityMoore(nums));
    }
}