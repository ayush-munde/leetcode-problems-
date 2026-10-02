class Solution {
    public int helper(int nums[],int k){
           int left=0;
        int oddCount=0;
        int count=0;
        int j=0;
        if(k<0)return 0;
         while( j<nums.length){
            if((nums[j]%2)!=0){
                oddCount++;
            }
         
            while(oddCount>k){
              
               if((nums[left]%2)!=0){

                oddCount--;
            }
            left++;
            }
            count+=j-left+1;
            j++;

        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
     return helper(nums,k)-helper(nums,k-1);
        
    }
}