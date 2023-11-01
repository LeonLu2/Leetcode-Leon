class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int pre = result;
        for(int i = 1; i < nums.length; i++){
            pre = Math.max(pre + nums[i], nums[i]); // see if we can extend the subarray
            if(pre > result) result = pre; // update the result if subarray sum is larger
        }
        return result;
    }
}
