class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // sort people by height in descending order
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];   // when a[0] == b[0], sort by k in ascending order
            return b[0] - a[0];   // when a[0] != b[0], sort by h in descending order
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);   // insert p at index p[1]
        }

        return que.toArray(new int[people.length][]);
    }
}
