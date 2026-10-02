class Solution {
    public int helper(int nums[],int goals){
        if(goals<0) return 0;
        int left=0;
        int  count=0;
        int sum=0;
        int j=0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>goals){
                  sum-=nums[left];
                  left++;

            }
            count+=j-left+1;
            j++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(nums.length==0) return 0;
        return helper(nums,goal)-helper(nums,goal-1);
    }
        
    }
