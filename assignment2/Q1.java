package Assignment2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1 {

    public static void main(String[] args) {
        int[] nums = {3,3};
        int tar = 6;
        System.out.println(Arrays.toString(sum(nums,tar)));

    }


    // Time complexity: O(n);
    // Space complexity: O(n);
    private static int[] sum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{i, map.get(j)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
