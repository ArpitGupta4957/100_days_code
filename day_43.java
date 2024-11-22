import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (matrix[i][m-1] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] ^= matrix[i][m-1];
                }
            }
            int count = map.merge(Arrays.hashCode(matrix[i]), 1, Integer::sum);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix));
    }
}