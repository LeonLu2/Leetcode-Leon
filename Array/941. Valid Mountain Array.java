class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) { // if the length of the array is less than 3, it can't be a mountain
            return false;
        }
        // double pointers
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        // if the left and right are both not the start and end of the array, and the left and right are the same, then it's a mountain
        if (left == right && left != 0 && right != arr.length - 1) {
            return true;
        }
        return false;
    }
}
