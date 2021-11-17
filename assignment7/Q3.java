package Assignment7;


import java.util.ArrayList;
import java.util.List;

public class Q3 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4) return res;

        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    int d = s.length() - a - b - c;
                    if (d > 0 && d < 4) {
                        int n1 = Integer.parseInt(s.substring(0, a));
                        int n2 = Integer.parseInt(s.substring(a, a + b));
                        int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
                        int n4 = Integer.parseInt(s.substring(a + b + c));
                        if (n1 < 256 && n2 < 256 && n3 < 256 && n4 < 256) {
                            String sb = String.format("%s.%s.%s.%s", n1, n2, n3, n4);
                            if (sb.length() == s.length() + 3) {
                                res.add(sb);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
// Time complexity: O(1);
// Space complexity: O(1);
