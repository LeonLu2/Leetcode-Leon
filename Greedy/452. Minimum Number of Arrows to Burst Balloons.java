/**
 * time: O(nlogn)
 * space complexity: O(logn) (use Arrays.sort() which is implemented by quick sort so it's O(logn))
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        // sort by end point in ascending order
        // use Integer.compare(a[1], b[1]) instead of (a, b) -> a[1] - b[1] to avoid overflow
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;  // points is not empty, so at least one arrow is needed
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {  // balloon i and balloon i-1 are not overlapped
                count++; // need one more arrow
            } else {  // balloon i and balloon i-1 are overlapped
                points[i][1] = Math.min(points[i][1], points[i - 1][1]); // update end point
            }
        }
        return count;
    }
}
