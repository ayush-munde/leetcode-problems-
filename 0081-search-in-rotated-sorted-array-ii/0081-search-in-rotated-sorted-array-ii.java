class Solution {

    public boolean searchm(int[] arr, int si, int ei, int k) {

        if (si > ei)
            return false;

        int mid = si + (ei - si) / 2;

        if (arr[mid] == k){
           return true;
        }
          if (arr[si] == arr[mid] && arr[mid] == arr[ei]) {
                return searchm(arr, si + 1, ei - 1, k);
                
            }
            

        // Left half is sorted
        if (arr[si] <= arr[mid]) {

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

    public boolean search(int[] nums, int target) {
        return searchm(nums, 0, nums.length - 1, target);
    }
}