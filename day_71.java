import java.util.*;

class day_71 {
    public int[] leftmostBuildingQueries(int[] h, int[][] queries) {
        int n = h.length;
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1); // Initialize the result array with -1
        
        // Map to store queries that cannot be answered directly
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for (int id = 0; id < m; id++) {
            int[] query = queries[id];
            int i = query[0];
            int j = query[1];
            
            if (i < j && h[i] < h[j]) {
                ans[id] = j;
            } else if (i > j && h[i] > h[j]) {
                ans[id] = i;
            } else if (i == j) {
                ans[id] = i;
            } else {
                map.computeIfAbsent(Math.max(i, j), k -> new ArrayList<>())
                   .add(new int[]{Math.max(h[i], h[j]), id});
            }
        }
        
        // Priority queue (min-heap) to process height queries
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        for (int id = 0; id < n; id++) {
            int curHeight = h[id];
            
            // Process all pending queries whose maximum height is less than the current building's height
            while (!pq.isEmpty() && pq.peek()[0] < curHeight) {
                int[] top = pq.poll();
                ans[top[1]] = id;
            }
            
            // Add pending queries related to the current building
            if (map.containsKey(id)) {
                for (int[] p : map.get(id)) {
                    pq.offer(p);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        day_71 d = new day_71();
        int[] h = {4, 2, 0, 3, 2, 5};
        int[][] queries = {{2, 4}, {3, 0}, {0, 2}, {0, 5}, {4, 1}, {1, 3}};
        int[] res = d.leftmostBuildingQueries(h, queries);
        System.out.println(Arrays.toString(res));
    }
}
