package Final;

public class Q3 {
    public static int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > curFarthest) return -1;
            if (i > curEnd) {
                jumps++;
                curEnd = curFarthest;
                if (curFarthest >= nums.length - 1) {
                    break;
                }
            }
            curFarthest = Math.max(curFarthest, i + nums[i]);
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(jump(arr));
    }
}
