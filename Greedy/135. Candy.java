class Solution {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * divide the problem into two parts:
     * 1. from left to right, if the right one is greater than the left one, the right one's candy = left one's candy + 1
     * 2. from right to left, if the left one is greater than the right one, the left one's candy should be the maximum of itself and the right one's candy + 1, so that it is greater than the left one and the right one
    */
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyVec = new int[len];
        candyVec[0] = 1;
        for (int i = 1; i < len; i++) {
            candyVec[i] = (ratings[i] > ratings[i - 1]) ? candyVec[i - 1] + 1 : 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }

        int ans = 0;
        for (int num : candyVec) {
            ans += num;
        }
        return ans;
    }
}
