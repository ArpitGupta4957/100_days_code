import java.util.*;
class day_24 {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        HashMap<Character, Integer> hs = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hs.put(ch, hs.getOrDefault(ch, 0) + 1);

            if (hs.get(ch) > 2) {
                sb.deleteCharAt(i);
                i--; // Adjust index after deletion
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        day_24 d = new day_24();
        System.out.println(d.makeFancyString("aaabbbcc")); // Output: "aabcc"
    }
}