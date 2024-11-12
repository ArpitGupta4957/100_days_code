class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b) -> a[0]-b[0]);

        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }

        for (int i = 0; i < queries.length; i++) {
            int low = 0, high = items.length - 1;
            int maxBeauty = 0;
            int query = queries[i];

            // Binary search for the highest price <= queryPrice
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (items[mid][0] <= query) {
                    maxBeauty = items[mid][1];
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            // Update queries[i] with the maximum beauty found
            queries[i] = maxBeauty;
        }
        return queries;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] items = {{1, 2}, {4, 3}, {3, 5}};
        int[] queries = {2, 3, 4, 5};
        int[] result = solution.maximumBeauty(items, queries);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}