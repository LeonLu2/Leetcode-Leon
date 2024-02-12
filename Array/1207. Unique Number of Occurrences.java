class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2002];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++; // prevent negative number as index
        }
        boolean[] flag = new boolean[1002]; // mark the repeated count
        for (int i = 0; i <= 2000; i++) {
            if (count[i] > 0) {
                if (flag[count[i]] == false) {
                    flag[count[i]] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
