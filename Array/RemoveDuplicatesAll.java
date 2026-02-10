import java.util.*;

public class RemoveDuplicatesAll {

    // 1. Brute Force (Using Extra Array)
    // Logic: Store unique elements in temp array
    // TC: O(n)
    // SC: O(n)

    static int brute(int[] nums) {
        if (nums.length == 0) return 0;

        int[] temp = new int[nums.length];
        int j = 0;

        temp[j++] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                temp[j++] = nums[i];
            }
        }

        for (int i = 0; i < j; i++) {
            nums[i] = temp[i];
        }

        return j;
    }
    // 2. Using HashSet
    // Logic: Insert into set to remove duplicates
    // TC: O(n)
    // SC: O(n)

    static int hashSet(int[] nums) {
        HashSet<Integer> set = new LinkedHashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int index = 0;
        for (int num : set) {
            nums[index++] = num;
        }

        return set.size();
    }
    // 3. Optimal (Two Pointer)
    // Logic: Slow pointer tracks unique position
    // TC: O(n)
    // SC: O(1)

    static int optimal(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,1,2,2,3};
        int[] arr2 = {1,1,2,2,3};
        int[] arr3 = {1,1,2,2,3};

        System.out.println(brute(arr1));
        System.out.println(hashSet(arr2));
        System.out.println(optimal(arr3));
    }
}
