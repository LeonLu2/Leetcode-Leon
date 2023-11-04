class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // Convert int[] to List<Integer>
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        
        // Sort the List by absolute value in descending order
        list.sort((o1, o2) -> Math.abs(o2) - Math.abs(o1));
        
        for (int i = 0; i < list.size(); i++) {
            // From front to back, if it is negative, make it positive, and decrement k
            if (list.get(i) < 0 && k > 0) {
                list.set(i, -list.get(i));
                k--;
            }
        }
        // If k is still greater than 0, repeatedly change the smallest value until k is used up
        if (k % 2 == 1) list.set(list.size() - 1, -list.get(list.size() - 1));
        
        // Convert the List back to an array and return the sum
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
