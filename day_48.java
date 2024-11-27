import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class day_48 {
    private int shortestPath(List<List<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int curr = queue.poll();
                if (curr == n - 1) {
                    return distance;
                }
                for (int neighbor : adj.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }
        return -1; // If there is no path to the last node
    }

    public List<Integer> shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; ++i) {
            adj.get(i).add(i + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            adj.get(query[0]).add(query[1]);
            result.add(shortestPath(adj, n));
        }
        return result;
    }
    public static void main(String[] args) {
        day_48 obj = new day_48();
        int n = 5;
        int[][] queries = {{0, 2}, {2, 3}, {3, 4}};
        List<Integer> result = obj.shortestDistanceAfterQueries(n, queries);
        System.out.println(result);
        
    }
}