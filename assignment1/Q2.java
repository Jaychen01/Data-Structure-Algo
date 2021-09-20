package Assignment1;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args){
        int[][] intervals = new int[][]{{0,30},{5,10}, {15,20}};
        System.out.println(judge(intervals));
        intervals = new int[][]{{7,10},{2,4}};
        System.out.println(judge(intervals));

    }

    public static boolean judge(int[][] intervals){
        Arrays.sort(intervals, (a , b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length - 1; i++){
            int[] arr1 = intervals[i];
            int[] arr2 = intervals[i + 1];
            if (arr1[1] > arr2[0]){
                return false;
            }
        }
        return true;
    }
}
// Time complexity: O(n);
// Space complexity: O(1);