import java.util.*;
public class two_Sum{

    // Brute Force Approach
    // Logic: Check every possible pair
    // Reminder: "No memory, just compare everything"
    // TC: O(n^2)

    public static int[] twoSumBrute(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // HashMap Approach (Optimal)
    // Logic: Store what you've seen, search what you need
    // Reminder: "Complement = target - current"
    // TC: O(n)

    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // Two Pointer Approach (Sorted Array Only)
    // Logic: If sum too small → move left
    //        If sum too big → move right
    // Reminder: "Sorted array? Use left & right"
    // TC: O(n)

    public static int[] twoSumTwoPointer(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while(left < right) {
            int sum = nums[left]+nums[right];

            if(sum == target) {
                return new int[]{left,right};
            }
            else if(sum <target) {
                left++;
            }
            else {
                right--; 
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {

        int[] arr = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSumBrute(arr, target)));
        System.out.println(Arrays.toString(twoSumHashMap(arr, target)));
        System.out.println(Arrays.toString(twoSumTwoPointer(arr, target)));
    }
}
