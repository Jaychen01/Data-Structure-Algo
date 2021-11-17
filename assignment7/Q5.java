package Assignment7;


import java.util.List;

public class Q5 {
    int max;
    public int maxLength(List<String> arr) {
        dfs(arr, 0, "");
        return max;
    }

    private void dfs(List<String> arr, int index, String str) {
        if (isUnique(str)) max = Math.max(max, str.length());
        if (index == arr.size() || !isUnique(str)) return;

        for (int i = index; i < arr.size(); i++) {
            dfs(arr, i + 1, str + arr.get(i));
        }
    }

    private boolean isUnique(String s) {
        if (s.length() > 26) return false;
        boolean[] arr = new boolean[26];
        for (char ch : s.toCharArray()) {
            if (arr[ch - 'a']) return false;
            else arr[ch - 'a'] = true;
        }
        return true;
    }
}
// Time complexity: O(2^n); n is the length of arr.
// Space complexity: O(n);
