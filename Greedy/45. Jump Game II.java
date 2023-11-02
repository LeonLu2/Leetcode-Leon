class Solution {
    public int jump(int[] nums) {
        int result = 0;
        // end is the maximum index we can reach
        int end = 0;
        // temp is the maximum index we can reach if we jump one more step
        int temp = 0;
        for (int i = 0; i <= end && end < nums.length - 1; ++i) {
            temp = Math.max(temp, i + nums[i]);
            // if we reach the end, we jump one more step
            if (i == end) {
                end = temp;
                result++;
            }
        }
        return result;
    }
}
