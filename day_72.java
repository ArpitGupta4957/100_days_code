import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
class day_72 {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> lst = new ArrayList<>();

            for(int i = 0;i<n;i++){
                TreeNode temp = queue.poll();
                lst.add(temp.val);

                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            res += swapToSort(lst);
        }
        return res;
    }

    private int swapToSort(List<Integer> nodes){
        List<Integer> sorted = new ArrayList<>(nodes);
        Collections.sort(sorted);
        int swaps = 0;

        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<sorted.size();i++){
            hm.put(nodes.get(i), i);
        }

        for(int i = 0;i<sorted.size();i++){
            if(nodes.get(i).equals(sorted.get(i))){
                continue;
            }

            int curr = hm.get(sorted.get(i));
            hm.put(nodes.get(i), curr);
            hm.put(nodes.get(curr), i);
            Collections.swap(nodes, curr, i);
            swaps++;
        }
        return swaps;
    }
    public static void main(String[] args) {
        day_72 obj = new day_72();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(obj.minimumOperations(root));
    }
}