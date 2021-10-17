package Assignment5;

public class Q1 {
    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        int sign = 1;
        int base = 0, i = 0;
        while (s.charAt(i) == ' ') {
            if(i == s.length() - 1) {
                return 0;
            }
            i++;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 + (s.charAt(i++) - '0');
        }
        return base * sign;
    }
}
// Time complexity: O(n);
// Space complexity: O(1);