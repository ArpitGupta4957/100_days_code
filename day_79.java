import java.util.Arrays;

class day_79 {
    int L, H, Z, O;
    final int M = 1_000_000_007; // Correct modulo value
    int[] dp;

    public int countGoodStrings(int low, int high, int zero, int one) {
        L = low;
        H = high;
        Z = zero;
        O = one;

        dp = new int[H + 1];
        Arrays.fill(dp, -1);

        return solve(0);
    }

    private int solve(int l) {
        if (l > H) {
            return 0; // Out of bounds, no valid string
        }

        if (dp[l] != -1) {
            return dp[l]; // Return already computed result
        }

        // Count this string only if its length is within bounds
        int count = (l >= L && l <= H) ? 1 : 0;

        // Try adding zero and one
        int takeZero = solve(l + Z);
        int takeOne = solve(l + O);

        // Store the result in dp and return
        dp[l] = (count + takeZero + takeOne) % M;
        return dp[l];
    }
    public static void main(String[] args) {
        day_79 obj = new day_79();
        System.out.println(obj.countGoodStrings(2, 2, 1, 1));
    }
}