class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // coverRange is the maximum index we can reach
        int coverRange = 0;
        // we can reach index i if i <= coverRange
        for (int i = 0; i <= coverRange; i++) {
            // update the coverRange
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) { // we can reach the last index
                return true;
            }
        }
        return false;
    }
}