class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        build(k, n, 1, 0);
        return ans;
    }

    private void build(int k, int n, int startIndex, int sum) {
        // if sum > n, then we can't reach the target
        if (sum > n) return;
        // if path.size() > k, then we already have k numbers, so we can't add more
        if (path.size() > k) return;
        // if sum == n and path.size() == k, then we find a solution
        if (sum == n && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // if sum < n and path.size() < k, then we can continue to add numbers
        for(int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            build(k, n, i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }
}
