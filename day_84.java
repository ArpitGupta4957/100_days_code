class day_84 {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Set<String> uniqueSubsequences = new HashSet<>();
        
        // Iterate through all characters as the middle character of the palindrome
        for (char mid = 'a'; mid <= 'z'; mid++) {
            int first = -1;
            int last = -1;
            
            // Find the first and last occurrence of the character
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == mid) {
                    if (first == -1) {
                        first = i;
                    }
                    last = i;
                }
            }
            
            // If first and last occurrences are valid and different
            if (first != -1 && last != -1 && first < last) {
                // Add all characters between first and last to the set
                for (int i = first + 1; i < last; i++) {
                    uniqueSubsequences.add("" + s.charAt(first) + s.charAt(i) + s.charAt(last));
                }
            }
        }
        return uniqueSubsequences.size();
    }
    public static void main(String[] args) {
        day_84 obj = new day_84();
        System.out.println(obj.countPalindromicSubsequence("aabca"));
    }
}