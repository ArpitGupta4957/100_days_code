class Solution {
    public int xorAllNums(int[] A, int[] B) {
    int x = 0, y = 0;
    for (int a: A)
        x ^= a;
    for (int b: B)
        y ^= b;
    return (A.length % 2 * y) ^ (B.length % 2 * x);
}
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1, 2, 3};
        int[] B = {1, 2, 3};
        System.out.println(s.xorAllNums(A, B));
    }
}