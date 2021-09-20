package Assignment1;

public class Q6 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,4};
        sortArray(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    public static void sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 0){
                swap(nums, left, i);
                left++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (nums == null || i < 0 || i > nums.length - 1 || j < 0 || j > nums.length - 1){
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// Time complexity: O(n);
// Space complexity: O(1);