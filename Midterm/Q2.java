package Midterm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q2 {
    public static void main(String[] args) {
        int[] arr = {3,1,0};
        System.out.println(missing(arr));

    }

    public static int missing(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length -1;
    }

}


