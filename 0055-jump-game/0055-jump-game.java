class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length-1;
        int i=0;
      int    maxReach=0;
        while(i<=maxReach){
            maxReach=Math.max(maxReach,i+nums[i]);
            if(maxReach>=n){
                return true;
            }
            i++;
        }
        return false;
        
    }
}