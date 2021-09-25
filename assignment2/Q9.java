package Assignment2;

public class Q9 {
    public static void main(String[] args){
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findElement(arr,k));

    }
    // Time complexity: O(log n);
    // Space complexity: O(1);
    private static int findElement(int[] nums, int k){
        if (nums[0] > k){
            return k;
        }
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] - mid - 1 >= k){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left + k;

    }
}
