package Assignment1;

import java.util.Arrays;

public class Q3 {

    public static void main(String[] args){
        int[] arr = new int[]{6,2,6,5,1,2};
        quickSort(arr);
        System.out.print(sum(arr));
    }

    private static int sum(int[] arr){
        int sum = 0;
        if (arr.length % 2 ==0){
            for(int i = 0; i < arr.length; i += 2)
               sum += arr[i];
        }
        return sum;
    }

    private static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high){
            int pos = partition(arr, low, high);
            quickSort(arr, low, pos - 1);
            quickSort(arr, pos + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int wall = low - 1;
        for (int i = low; i < high; i++){
            if(arr[i] < pivot){
                wall++;
                swap(arr, i, wall);

            }
        }
        wall++;
        swap(arr, high, wall);
        return wall;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

// Time complexity: O(n log n);
// Space complexity: O(1);