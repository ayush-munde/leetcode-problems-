class Solution {
    public int removeDuplicates(int[] nums) {
        
        int n=nums.length;
        int uniquePosition = 1;
 
        for (int current = 1; current < n; current++) {
            /*
             * A different value means a new
             * unique element has been found.
             */
            if (nums[current] != nums[uniquePosition - 1]) {
                nums[uniquePosition] = nums[current];
                uniquePosition++;
            }
        }
        return uniquePosition;
    }
}