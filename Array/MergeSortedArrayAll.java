import java.util.*;

public class MergeSortedArrayAll {

    // Extra Array
    // Reminder: "Compare fronts, fill temp"
    static void extraArray(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;

        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }

        while(i < m) temp[k++] = nums1[i++];
        while(j < n) temp[k++] = nums2[j++];

        for(int x = 0; x < m + n; x++) {
            nums1[x] = temp[x];
        }
    }

    // Optimal (No Extra Space)
    // Reminder: "Fill from back"
    static void optimal(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1; 
        int j = n - 1;     
        int k = m + n - 1;  

        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {1,2,3,0,0,0};

        int[] nums2 = {2,5,6};

        extraArray(arr1, 3, nums2, 3);
        optimal(arr2, 3, nums2, 3);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
// Both → O(m + n)
// Extra uses space
// Optimal uses O(1) space