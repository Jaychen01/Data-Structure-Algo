package Assignment2;

public class Q8 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,4,5};
        System.out.println(findDup(arr));
        arr = new int[]{1,1};
        System.out.println(findDup(arr));

    }
    // Time complexity: O(n log n);
    // Space complexity: O(1);
    private static int findDup(int[] nums){
        int left = 1;
        int right = nums.length - 1;
        int res = -1;

        while (left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            for(int i =0; i < nums.length; i++){
                if (nums[i] <= mid) count++;
            }
            if (count <= mid){
                left = mid + 1;
            }else {
                res = mid;
                right = mid - 1;

            }
        }
        return res;

    }
}
