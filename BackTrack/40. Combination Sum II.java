class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort the candidates array to make the same elements adjacent
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return res;
    }
    
    private void backTracking(int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++){
            // skip the same elements
            if (i > start && candidates[i] == candidates[i - 1]){
                continue;
            }

            sum += candidates[i];
            path.add(candidates[i]);
            // i+1 because we cannot reuse the same elements
            backTracking(candidates, target, i + 1);

            int temp = path.getLast();
            sum -= temp;
            path.removeLast();
        }
    }
}
