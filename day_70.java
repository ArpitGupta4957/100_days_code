import java.util.ArrayList;
import java.util.List;

class day_70 {
    private int dfs(List<List<Integer>> adj, int[] values, int k, int[] count, int curr, int parent) {
        long sum = values[curr];
        for (int nbr : adj.get(curr)) {
            if (nbr != parent) {
                sum += dfs(adj, values, k, count, nbr, curr);
            }
        }
        sum %= k;
        if (sum == 0) count[0]++;
        return (int) sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] count = {0};
        dfs(adj, values, k, count, 0, -1);
        return count[0];
    }
    public static void main(String[] args) {
        day_70 obj = new day_70();
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {4, 5}, {5, 6}, {6, 7}, {7, 4}};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        System.out.println(obj.maxKDivisibleComponents(n, edges, values, k));
    }
}