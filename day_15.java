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
 
class day_15 {
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root ==null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int levelSum = root.val;

        while(!queue.isEmpty()){
            int n = queue.size();
            int nextLevelSum = 0;

            for(int i = 0;i<n;i++){
                TreeNode curr = queue.poll();

                curr.val = levelSum - curr.val;

                int siblingSum = (curr.left!=null ? curr.left.val : 0) + (curr.right!=null ? curr.right.val : 0);
                if (curr.left != null) {
                    nextLevelSum += curr.left.val;
                    curr.left.val = siblingSum;
                    queue.add(curr.left);
                }

                // Process right child
                if (curr.right != null) {
                    nextLevelSum += curr.right.val;
                    curr.right.val = siblingSum;
                    queue.add(curr.right);
                }
            }
            levelSum = nextLevelSum;
        }
        return root;
    }
    public static void main(String[] args) {
        day_15 obj = new day_15();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        obj.replaceValueInTree(root);
    }
}