package Final;

public class Q4 {

    public static boolean alienLanguage(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    if (order.indexOf(String.valueOf(c1)) > order.indexOf(String.valueOf(c2))){
                        return false;
                    } else {
                        break;
                    }
                } else {
                    if (j == len - 1 && word1.length() > word2.length()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(alienLanguage(words, order));
    }
}
