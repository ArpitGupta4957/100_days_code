import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class day_74 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) return lst;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            int maxVal = Integer.MIN_VALUE;
            
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                maxVal = Math.max(maxVal, curr.val);
                
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            lst.add(maxVal);
        }
        return lst;
    }
    public static void main(String[] args) {
        day_74 obj = new day_74();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(obj.largestValues(root));
    }
}