class day_22 {
    public int minimumMountainRemovals(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int[] LIS = new int[nums.length];
        int[] LDS = new int[nums.length];

        // Find LIS for each element
        findLIS(nums, LIS);

        // Find LDS for each element
        findLDS(nums, LDS);

        int minRemovals = nums.length;

        // Calculate minimum removals to make the array a mountain array
        for (int i = 0; i < nums.length; i++) {
            if (LIS[i] > 1 && LDS[i] > 1) {
                minRemovals = Math.min(minRemovals, nums.length - (LIS[i] + LDS[i] - 1));
            }
        }

        return minRemovals;
    }

    // Function to calculate Longest Increasing Subsequence (LIS) up to each element
    private void findLIS(int[] nums, int[] LIS) {
        for (int i = 0; i < nums.length; i++) {
            LIS[i] = 1; // each element alone is a subsequence
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
    }

    // Function to calculate Longest Decreasing Subsequence (LDS) from each element
    private void findLDS(int[] nums, int[] LDS) {
        for (int i = nums.length - 1; i >= 0; i--) {
            LDS[i] = 1; // each element alone is a subsequence
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        day_22 obj = new day_22();
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(obj.minimumMountainRemovals(nums));
    }
}