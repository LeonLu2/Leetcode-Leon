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
        levelAverage(root, 0);
        for(double[] cur : store) res.add(cur[0] / cur[1]);
        return res;
    }

    public void levelAverage(TreeNode curr, int Depth){
        if(curr == null) return;
        if(store.size() <= Depth) store.add(new double[2]);
        store.get(Depth)[0] += curr.val;
        store.get(Depth)[1]++;
        levelAverage(curr.left, Depth + 1);
        levelAverage(curr.right, Depth + 1);
    }
}
