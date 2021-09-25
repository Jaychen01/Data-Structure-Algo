package Assignment2;

public class Q7 {
    public static void main(String[] args){
        int[] arr= {1,2,1,3,5,6,4};
        System.out.println(findPeak(arr));
    }

    // Time complexity: O(log n);
    // Space complexity: O(1);

    private static int findPeak(int[] nums){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
