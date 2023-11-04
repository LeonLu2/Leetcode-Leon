class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            // If curSum < 0, we cannot start from the previous index, so we start from the current index
            if (curSum < 0) {
                index = (i + 1) % gas.length ; 
                curSum = 0;
            }
        }
        // If totalSum < 0, we cannot complete the circuit
        if (totalSum < 0) return -1;
        return index;
    }
}
