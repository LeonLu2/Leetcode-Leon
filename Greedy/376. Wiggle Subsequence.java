class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // current difference
        int curDiff = 0;
        // last difference
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // get the difference between current and previous element
            curDiff = nums[i] - nums[i - 1];
            // if there is a sign change, we can count it as a wiggle subsequence
            // if there is no sign change, we can ignore it
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
