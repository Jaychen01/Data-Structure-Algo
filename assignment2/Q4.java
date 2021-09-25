package Assignment2;

import java.util.ArrayList;
import java.util.List;

public class Q4 {
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        majorElements(arr);
        System.out.println(majorElements(arr));

    }

    // Time complexity: O(n);
    // Space complexity: O(1);
    private static List<Integer> majorElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int i : nums) {
            if (candidate1 == i) {
                count1++;
                continue;
            } else if (candidate2 == i) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                candidate1 = i;
                count1++;
                continue;
            }
            if (count2 == 0) {
                candidate2 = i;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (candidate1 == i) {
                count1++;
            } else if (candidate2 == i) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            list.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            list.add(candidate2);
        }
        return list;
    }
}