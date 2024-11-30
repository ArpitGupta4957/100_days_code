import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class day_51 {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Map<Integer, Integer> inOutDegree = new HashMap<>();
        
        // Build graph and count in/out degrees
        for (int[] pair : pairs) {
            adjacencyList.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            inOutDegree.merge(pair[0], 1, Integer::sum);  // out-degree
            inOutDegree.merge(pair[1], -1, Integer::sum);  // in-degree
        }
        
        // Find starting node
        int startNode = pairs[0][0];
        for (Map.Entry<Integer, Integer> entry : inOutDegree.entrySet()) {
            if (entry.getValue() == 1) {
                startNode = entry.getKey();
                break;
            }
        }
        
        List<Integer> path = new ArrayList<>();
        Deque<Integer> nodeStack = new ArrayDeque<>();
        nodeStack.push(startNode);
        
        while (!nodeStack.isEmpty()) {
            List<Integer> neighbors = adjacencyList.getOrDefault(nodeStack.peek(), new ArrayList<>());
            if (neighbors.isEmpty()) {
                path.add(nodeStack.pop());
            } else {
                int nextNode = neighbors.get(neighbors.size() - 1);
                nodeStack.push(nextNode);
                neighbors.remove(neighbors.size() - 1);
            }
        }
        
        int pathSize = path.size();
        int[][] arrangement = new int[pathSize - 1][2];
        
        for (int i = pathSize - 1; i > 0; --i) {
            arrangement[pathSize - 1 - i] = new int[]{path.get(i), path.get(i-1)};
        }
        
        return arrangement;
    }
    public static void main(String[] args) {
        day_51 d = new day_51();
        int[][] pairs = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}}; // Output: [[1,4],[2,3],[3,4],[4,1],[1,3],[2,4]]
        int[][] result = d.validArrangement(pairs);
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }
}