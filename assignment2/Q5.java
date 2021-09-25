package Assignment2;

import java.util.Arrays;

public class Q5 {
    public static void main(String[] args){
        int[] arr = {5,7,7,8,8,10};
        int tar = 6;
        System.out.println(Arrays.toString(searchPosition(arr,tar)));

    }
    // Time complexity: O(log n);
    // Space complexity: O(1);
    private static int[] searchPosition(int[] nums, int tar){
        if (nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int start = findLeft(nums, tar);
        if (start == -1) return new int[]{-1, -1};

        int end = findRight(nums, tar);
        return new int[]{start, end};
    }


    private static int findLeft(int[] nums, int tar) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= tar) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length) return -1;
        return nums[left] == tar ? left : -1;
    }

    private static int findRight(int[] nums, int tar) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= tar) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left - 1;
    }

}
