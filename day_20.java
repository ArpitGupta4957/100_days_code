import java.util.*;
class day_20 {
    public int longestSquareStreak(int[] nums) {

        Set<Long> hs = new HashSet<>();
        for (int num : nums) {
            hs.add((long) num);  // Convert to long to prevent overflow
        }

        int maxStreak = 0;

        for (int num : nums) {
            int currentStreak = 0;
            long current = num;

            // Check consecutive squares in the set
            while (hs.contains(current)) {
                currentStreak++;
                // Break if square exceeds maximum array element to avoid unnecessary calculations
                if (current*current > 1e5) break;
                current *= current;
            }

            maxStreak = Math.max(maxStreak, currentStreak);
        }

        return maxStreak > 1 ? maxStreak : -1;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        day_20 obj = new day_20();
        System.out.println(obj.longestSquareStreak(nums));
    }
}