
public class maxProductSubarray {
    // 1. Brute Force
    // TC: O(n^2)
    // SC: O(1)
    static int brute(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }
    // 2. Optimal (Track max and min)
    // TC: O(n)
    // SC: O(1)
    static int optimal(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }
            maxSoFar = Math.max(nums[i], maxSoFar * nums[i]);
            minSoFar = Math.min(nums[i], minSoFar * nums[i]);
            result = Math.max(result, maxSoFar);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        System.out.println(brute(arr));
        System.out.println(optimal(arr));
    }
}
