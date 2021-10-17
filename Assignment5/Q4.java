package Assignment5;

public class Q4 {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 2; i <= n; i++){
            res = next(res);
        }
        return res;
    }
    private String next(String input) {
        StringBuilder sb = new StringBuilder();
        char[] arr = input.toCharArray();
        char curr = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == curr){
                count++;
            } else {
                sb.append(count).append(curr);
                curr = arr[i];
                count = 1;
            }
        }
        sb.append(count).append(curr);
        return sb.toString();
    }
}
// Time complexity: O(n * m);
// Space complexity: O(m), m is the length of the output string;