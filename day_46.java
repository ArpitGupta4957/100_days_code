import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int slidingPuzzle(int[][] board) {
        // Convert the board into a single string representation.
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }

        // Target configuration.
        String target = "123450";

        // Adjacency list for each position in the flattened board.
        Map<Integer, int[]> mp = new HashMap<>();
        mp.put(0, new int[]{1, 3});
        mp.put(1, new int[]{0, 2, 4});
        mp.put(2, new int[]{1, 5});
        mp.put(3, new int[]{0, 4});
        mp.put(4, new int[]{1, 3, 5});
        mp.put(5, new int[]{2, 4});

        // Queue for BFS and a set to track visited states.
        Queue<String> queue = new LinkedList<>();
        queue.offer(start.toString());

        Set<String> visited = new HashSet<>();
        visited.add(start.toString());

        int level = 0;

        // BFS loop.
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                String curr = queue.poll();

                // Check if we've reached the target state.
                if (curr.equals(target)) {
                    return level;
                }

                // Find the index of '0' in the current configuration.
                int currIdx = curr.indexOf('0');

                // Explore all possible moves by swapping '0' with its neighbors.
                for (int swapIdx : mp.get(currIdx)) {
                    char[] newArray = curr.toCharArray();

                    // Swap the '0' with its neighbor.
                    char temp = newArray[currIdx];
                    newArray[currIdx] = newArray[swapIdx];
                    newArray[swapIdx] = temp;

                    String newState = new String(newArray);

                    // Add the new state to the queue if it hasn't been visited.
                    if (!visited.contains(newState)) {
                        queue.offer(newState);
                        visited.add(newState);
                    }
                }
            }
            level++;
        }

        // If no solution is found, return -1.
        return -1;
    }
    public static void main(String[] args) {
        int[][] board = {{5,1,7},{6,0,3},{2,8,4}};
        Solution s = new Solution();
        System.out.println(s.slidingPuzzle(board));
    }
}