class day_1 {
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;  // Count an unmatched opening bracket
            } else {
                if (left > 0) {
                    left--;  // Match an opening bracket
                } else {
                    right++;  // Count an unmatched closing bracket
                }
            }
        }

        return left + right;  // Sum of unmatched left and right brackets
    }
}