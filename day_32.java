class Solution {
    public long minEnd(int n, int x) {
        long num = x;

        for(int i = 1;i<n;i++){
            num = (num+1)|x;
        }
        return num;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minEnd(3, 2));
    }
}