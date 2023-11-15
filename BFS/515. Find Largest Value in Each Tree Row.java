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
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>(List.of(root));
        while(q.size() != 0){
            int length = q.size();
            int max = q.peek().val;
            for(int i = 0; i < length; i++){
                TreeNode curr = q.poll();
                if(curr.val > max) max = curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            res.add(max);
        }
        return res;
    }
}
