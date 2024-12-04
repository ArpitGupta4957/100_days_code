class day_55 {
    public boolean canMakeSubsequence(String source, String target) {
        int srcLen = source.length();
        int tgtLen = target.length();
        int srcIdx = 0;
        int tgtIdx = 0;
        
        while (srcIdx < srcLen && tgtIdx < tgtLen) {
            char srcChar = source.charAt(srcIdx);
            char tgtChar = target.charAt(tgtIdx);
            
            if (srcChar == tgtChar || 
                (srcChar == 'z' && tgtChar == 'a') || 
                (srcChar + 1 == tgtChar)) {
                srcIdx++;
                tgtIdx++;
            } else {
                srcIdx++;
            }
        }
        return tgtIdx == tgtLen;
    }
    public static void main(String[] args) {
        day_55 solution = new day_55();
        System.out.println(solution.canMakeSubsequence("abc", "ahbgdc")); // true
        System.out.println(solution.canMakeSubsequence("abc", "ahbgd")); // false
    }
}