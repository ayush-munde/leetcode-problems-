class Solution {

    public static boolean allocate(int[] nums, int capacity, int k) {
        int pages = 0;
        int students = 1;

        for (int num : nums) {
            if (pages + num > capacity) {
                students++;
                pages = num;
            } else {
                pages += num;
            }
        }

        return students > k;
    }

    public int splitArray(int[] nums, int k) {

        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (allocate(nums, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}