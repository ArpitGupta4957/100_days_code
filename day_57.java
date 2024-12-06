import java.util.HashSet;

class day_57 {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Use a HashSet for efficient lookup of banned numbers
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int count = 0, sum = 0;

        // Iterate over all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i) && sum + i <= maxSum) {
                sum += i; // Add the current number to the sum
                count++;  // Increment the count of valid numbers
            }
        }

        return count; // Return the maximum count
    }
    public static void main(String[] args) {
        day_57 obj = new day_57();
        int[] banned = {1, 2, 3};
        int n = 5;
        int maxSum = 3;
        System.out.println(obj.maxCount(banned, n, maxSum));
    }
}