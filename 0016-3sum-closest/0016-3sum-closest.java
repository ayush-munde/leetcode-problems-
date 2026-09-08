class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                // Check whether current sum is closer
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                // Move pointers
                if (sum < target) {
                    j++;
                } 
                else if (sum > target) {
                    k--;
                } 
                else {
                    return sum;
                }
            }
        }

        return closest;
    }
}