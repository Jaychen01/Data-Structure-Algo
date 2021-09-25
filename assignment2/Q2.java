package Assignment2;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Q2 {
    public static void main(String[] args){
        int[][] interval = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minNum(interval));
        interval = new int[][]{{7,10},{2,4}};
        System.out.println(minNum(interval));

    }
    // Time complexity: O(n log n);
    // Space complexity: O(n);
    private static int minNum(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] arr = intervals[i];
            map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
            map.put(arr[1], map.getOrDefault(arr[1], 0) - 1);

        }
        int curr = 0, result = 0;
        for (int i : map.values()) {
            curr += i;
            result = Math.max(result, curr);
        }
        return result;
    }

}
