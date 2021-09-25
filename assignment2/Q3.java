package Assignment2;

import java.util.Arrays;

public class Q3 {
    public static void main(String[] args){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }

    // Time complexity: O(n1 log n1 + n2 log n2);
    // Space complexity: O(log n1 + log n2);
    private static int[] intersection(int[] nums1, int[] nums2){
        if (nums1 == null || nums2 == null || nums1.length ==0 || nums2.length ==0){
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] arr = new int[n1];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2){
            if (nums1[i] == nums2[j]){
                if (k == 0 || nums1[i] != arr[k-1]){
                    arr[k++] = nums1[i];

                }
                i++;
                j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        return Arrays.copyOf(arr, k);
    }
}
