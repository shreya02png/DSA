
public class trappingRainWater {
    // 1. Brute Force
    // TC: O(n^2)
    // SC: O(1)
    static int brute(int[] height) {
        int n = height.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int l = 0; l <= i; l++) {
                leftMax = Math.max(leftMax, height[l]);
            }
            for (int r = i; r < n; r++) {
                rightMax = Math.max(rightMax, height[r]);
            }
            total += Math.min(leftMax, rightMax) - height[i];
        }
        return total;
    }
    // 2. Better (Prefix & Suffix Arrays)
    // TC: O(n)
    // SC: O(n)
    static int better(int[] height) {
        int n = height.length;
        int total = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return total;
    }
    // 3. Optimal (Two Pointer)
    // TC: O(n)
    // SC: O(1)
    static int optimal(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    total += leftMax - height[left];
                }
                left++;

            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    total += rightMax - height[right];
                }
                right--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(brute(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }
}
