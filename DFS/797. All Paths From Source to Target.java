class Solution {
    List<List<Integer>> ans;
    List<Integer> cnt;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>(); // store all paths
        cnt = new ArrayList<>(); // store current path
        cnt.add(0);
        helper(graph, 0);
        return ans;
    }
    
    private void helper(int[][] graph, int node){
        if(node == graph.length - 1){
            ans.add(new ArrayList<>(cnt));
            return;
        }
        for(int i = 0; i < graph[node].length; ++i){
            int next = graph[node][i];
            cnt.add(next);
            helper(graph, next);
            cnt.remove(cnt.size() - 1);
        }
    }
}
