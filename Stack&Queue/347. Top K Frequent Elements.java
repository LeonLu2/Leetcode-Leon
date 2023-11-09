class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();// key is the number, value is the frequency
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        // small heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){// small heap only needs to sustain k elements in sequence
            if(pq.size() < k){ // if the size of the heap is less than k, add the element
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if(entry.getValue() > pq.peek()[1]){// the frequency of the current element is larger than the smallest element in the heap
                    pq.poll(); // poll the smallest element
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--){ // pop the elements from the heap
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
