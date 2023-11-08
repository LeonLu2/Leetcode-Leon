class MyQueue {
    Deque<Integer> deque = new LinkedList<>();
    // when the first element of the sliding window is removed, check if the first element of the queue is the same
    // if so, remove it; 
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }
    // when a new element is added to the sliding window, remove all the elements in the queue that are smaller than it
    // ensure that the first element of the queue is the max value of the sliding window
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }
    // this.peek() is the max value in the queue
    int peek() {
        return deque.peek();
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        // res stores the max value of each window
        int[] res = new int[len];
        int num = 0;
        // myQueue stores the index of each element
        MyQueue myQueue = new MyQueue();
        // initialize the queue with the first k elements
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            // sliding window remove the first element
            myQueue.poll(nums[i - k]);
            // sliding window add the last element
            myQueue.add(nums[i]);
            // record the max value of each window
            res[num++] = myQueue.peek();
        }
        return res;
    }
}
