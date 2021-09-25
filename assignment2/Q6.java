package Assignment2;

public class Q6 {
    public static void main(String[] args){
        int[][] grid = new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(count(grid));
        grid = new int[][]{{1,-1},{-1,-1}};
        System.out.println(count(grid));

    }
    // Time complexity: O(m log n);
    // Space complexity: O(1);
    private static int count(int[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int res = 0, index = m;
        for (int i = 0; i < m; i++){
            int left = 0;
            int right = index;
            while (left < right){
                int mid = (left + right) / 2;
                if (grid[i][mid] < 0){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            res += m - left;
            index = left;
        }
        return res;
    }
}
