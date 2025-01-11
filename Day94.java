import java.util.HashMap;

class Day94{
    //Construct K Palindrome Strings (leetcode)
    public boolean canConstruct(String s, int k) {
        if (k > s.length()){
            return false;
        } 

        int count[] = new int[26];  
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int oddCount = 0;
        for (int i : count) {
            if (i % 2 != 0) {
                oddCount++;
            }
        }
        return k >= oddCount;
    }

    //Longest substring with distinct characters
    public int longestUniqueSubstr(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int count = 0, i = 0;

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            
            if (mp.containsKey(ch)) {
                i = Math.max(i, mp.get(ch) + 1);
            }
            mp.put(ch, j);
            count = Math.max(count, j - i + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Day94 day94 = new Day94();
        System.out.println(day94.canConstruct("annabelle", 2));
        System.out.println(day94.canConstruct("leetcode", 3));

        String s = "geeksforgeeks";
        System.out.println(day94.longestUniqueSubstr(s));
    }
}