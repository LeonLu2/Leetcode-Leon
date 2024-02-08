class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(result, new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int sum, int index){
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(result, path, candidates, target, sum + candidates[i], i); // i not i + 1 because we can reuse same elements
            path.remove(path.size() - 1);
        }
    }
}
