package Midterm;

public class Q1 {

    public static void main(String[] args){
        int[] arr = {0,1,0,3,0};
        move(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ",");
        }

    }

    public static int[] move(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] == 0 && arr[r] != 0) {
                swap(arr, l, r);
                l++;
                r--;
            } else if (arr[l] == 0 && arr[r] == 0){
                r--;

            } else {
                l++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
// Time complexity: O(n);
// Space complexity: O(1);