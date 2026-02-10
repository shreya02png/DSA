import java.util.*;

public class containsDuplicate {
// Brute / Extra Array
// Compare both arrays from the front.
// Put smaller element into a new temp array."
    static boolean brute(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Sorting
    // Reminder: "Duplicates become neighbors"
    static boolean sorting(int[] nums) {
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // HashSet (Best)
    // Reminder: "If already seen → duplicate"
    static boolean hashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,1};
        int[] arr2 = {1,2,3,1};
        int[] arr3 = {1,2,3,1};

        System.out.println(brute(arr1));
        System.out.println(sorting(arr2));
        System.out.println(hashSet(arr3));
    }
}
// Brute → O(n²)
// Sorting → O(n log n)
// HashSet → O(n)