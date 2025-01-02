class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] res = new int[queries.length];
        int z = 0; // Pointer to result array
        String vowels = "aeiou"; // Vowel set

        // Precompute whether each word starts and ends with a vowel
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String str = words[i];
            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);
            prefixSum[i + 1] = prefixSum[i] + (vowels.indexOf(first) != -1 && vowels.indexOf(last) != -1 ? 1 : 0);
        }

        // Process each query using the prefix sum array
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            // Handle circular array by wrapping indices
            int count = 0;
            if (end < n) {
                count = prefixSum[end + 1] - prefixSum[start];
            } else {
                count = prefixSum[n] - prefixSum[start] + prefixSum[(end % n) + 1];
            }

            res[z++] = count; // Add result for the current query
        }

        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"aeiou", "aeiou", "aeiou", "aeiou", "aeiou"};
        int[][] queries = {{0, 4}, {1, 3}, {0, 3}, {3, 3}};
        int[] res = solution.vowelStrings(words, queries);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
