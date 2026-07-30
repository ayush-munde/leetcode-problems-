class Solution {

    public int searchm(int[] arr, int si, int ei, int k) {

        if (si > ei)
            return -1;

        int mid = si + (ei - si) / 2;

        if (arr[mid] == k)
            return mid;

        // Left half is sorted
        if (arr[si] <= arr[mid]){

            if (arr[si] <= k && k <= arr[mid]) {
                return searchm(arr, si, mid - 1, k);
            } else {
                return searchm(arr, mid + 1, ei, k);
            }
        }

        // Right half is sorted
        else {

            if (arr[mid] <= k && k <= arr[ei]) {
                return searchm(arr, mid + 1, ei, k);
            } else {
                return searchm(arr, si, mid - 1, k);
            }
        }
    }

    public int search(int[] nums, int target) {
        return searchm(nums, 0, nums.length - 1, target);
    }
}