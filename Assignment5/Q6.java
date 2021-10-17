package Assignment5;

public class Q6 {
    public int pivotIndex(int[] nums) {
        int sumTotal = 0;
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            sumTotal += nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == sumTotal - sumLeft * 2) {
                return j;
            }
            sumLeft += nums[j];
        }
        return -1;
    }
}
// Time complexity: O(n);
// Space complexity: O(1);
