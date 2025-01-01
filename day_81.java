class Solution {
    public int maxScore(String s) {
        int countZero = 0;
        int countOne = 0;
        int maxScore = Integer.MIN_VALUE;

        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i) == '1'){
                countOne++;
            }
            else{
                countZero++;
            }
            maxScore = Math.max(maxScore, countZero - countOne);
        }

        if(s.charAt(s.length()-1) == '1'){
            countOne++;
        }
        return countOne + maxScore;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxScore("011101"));
    }
}