class day_59 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        // Precompute the alternating prefix
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if (nums[i - 1] % 2 != nums[i] % 2) {
                prefix[i]++;
            }
        }

        // Result array for queries
        boolean[] special = new boolean[q];

        // Answer each query in O(1)
        for (int i = 0; i < q; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            // Check if the range is alternating
            special[i] = (prefix[end] - prefix[start] == end - start);
        }

        return special;
    }
    public static void main(String[] args) {
        day_59 obj = new day_59();
        int[] nums = {1, 2, 3, 4, 5};
        int[][] queries = {{0, 2}, {1, 3}, {0, 3}, {2, 4}};
        boolean[] result = obj.isArraySpecial(nums, queries);
        System.out.println(java.util.Arrays.toString(result));
    }
}