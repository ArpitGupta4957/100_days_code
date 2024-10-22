import java.util.*;

 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
 
class day_14 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            pq.offer(sum);

            // Keep only the largest k sums in the priority queue
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // If the number of levels is less than k, return -1
        if (pq.size() < k) {
            return -1;
        }

        // The top of the priority queue is the kth largest level sum
        return pq.peek();
    }
}