package Assignment1;

public class Q1 {
    public static void main(String[] args){
        int[] arr = new int[]{2,2,0,1,0,1};
        sortArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    private static void sortArray(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++){
            if (nums[i] == 0){
                swap(nums, left, i);
                left++;
            }else if (nums[i] == 2){
                swap(nums, right, i);
                right--;
                i--;
            }
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// Time complexity: O(n);
// Space complexity: O(1);