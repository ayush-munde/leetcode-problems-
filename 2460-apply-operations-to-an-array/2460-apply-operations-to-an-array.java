class Solution {
    public int[] applyOperations(int[] nums) {
        int i=0;
        while(i<nums.length-1){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
                i+=2;
            }
            else{
                i++;
            }
        }
      i=0;
        int k=0;

        while(i<nums.length){
            if(nums[i]!=0){
                int  temp=nums[i];
                nums[i]=nums[k];
                nums[k]=temp;
                k++;

            }
            i++;
        }
        return nums;
        

    }
}