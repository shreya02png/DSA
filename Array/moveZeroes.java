import java.util.*;

public class moveZeroes {

    // Brute Force (Extra Array)
    // Logic: Store non-zero first, then add zeros
    // Reminder: "Collect non-zero, then fill zero"
    // TC: O(n)
    // SC: O(n)

    public static void moveZeroesBrute(int[] nums) {

        int[] temp = new int[nums.length];
        int index = 0;

        // Store non-zero elements
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                temp[index++] = nums[i];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    // Better Approach (Two Pass, In-place)
    // Logic: Shift non-zero forward, fill remaining with 0
    // Reminder: "Overwrite from front"
    // TC: O(n)
    // SC: O(1)

    public static void moveZeroesBetter(int[] nums) {

        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while(index < nums.length) {
            nums[index++] = 0;
        }
    }

    // Optimal Approach (Single Pass Swap)
    // Logic: Swap zero with next non-zero
    // Reminder: "Zero found? Swap with next non-zero"
    // TC: O(n)
    // SC: O(1)

    public static void moveZeroesOptimal(int[] nums) {

        int left = 0;  // position for next non-zero

        for(int right = 0; right < nums.length; right++) {

            if(nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0,1,0,3,12};
        int[] nums3 = {0,1,0,3,12};

        moveZeroesBrute(nums1);
        System.out.println("Brute: " + Arrays.toString(nums1));

        moveZeroesBetter(nums2);
        System.out.println("Better: " + Arrays.toString(nums2));

        moveZeroesOptimal(nums3);
        System.out.println("Optimal: " + Arrays.toString(nums3));
    }
}