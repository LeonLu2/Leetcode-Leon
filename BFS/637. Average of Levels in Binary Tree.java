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
    List<double[]> store = new ArrayList<>(); // it will store sum, no. of nodes at each level
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        Queue<TreeNode> level = new LinkedList<>(List.of(root));
        while(level.size() > 0){
            double length = level.size(), currSum = 0;
            for(int i = 0; i < length; i++){
                TreeNode curr = level.poll();
                currSum += curr.val;
                if(curr.left != null) level.offer(curr.left);
                if(curr.right != null) level.offer(curr.right);
            }
            res.add(currSum / length);
        }
        return res;
    }
}
