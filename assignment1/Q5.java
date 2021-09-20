package Assignment1;

import java.util.HashMap;
import java.util.Map;

public class Q5 {

    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));

    }

    public static boolean isAnagram(String s, String t){
        if (s == null || t == null){
            return false;
        }
        if (s.length() != t.length()){
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : s1){
            map1.put(c, map1.getOrDefault(c,0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : t1){
            map2.put(c, map2.getOrDefault(c,0) + 1);
        }

        return map1.equals(map2);

    }
}
// Time complexity: O(n);
// Space complexity: O(c); c is the alphabet size.