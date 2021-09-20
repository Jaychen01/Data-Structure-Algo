package Assignment1;

import java.util.Arrays;

public class Q4 {
    public static void main(String[] args){
        int[] arr = new int[]{-4,-1,0,0,0};
        sortArray(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void sortArray(int[] nums){
        for (int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
       // Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int index = 1;
        int min = findMin(nums);
        int k = min - 1;
        int j = min + 1;
        temp[0] = nums[min];

            while (k >= 0 && j < nums.length) {
                if (nums[k] <= nums[j]) {
                    temp[index] = nums[k];
                    k--;

                } else {
                    temp[index] = nums[j];
                    j++;
                }
                index++;
            }
            while (k >= 0) {
                temp[index] = nums[k];
                k--;
                index++;
            }
            while (j < nums.length) {
                temp[index] = nums[j];
                j++;
                index++;
            }

        for (int i = 0; i < temp.length; i++) {
                nums[i] = temp[i];
        }

    }

    private static int findMin(int[] nums){
        for (int i = 0; i < nums.length - 1; i++){
            if ( nums[i] < nums[i + 1]){
                return i;
            }
        }
        return (nums.length - 1);
    }
}
// Time complexity: O(n);
// Space complexity: O(n);