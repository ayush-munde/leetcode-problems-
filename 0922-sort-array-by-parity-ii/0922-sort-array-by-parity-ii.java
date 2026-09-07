class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int even=0,odd=1;
        int arr[]=new int[nums.length];
        int k=0;
        while(k<nums.length){
            if(nums[k]%2==0){
                arr[even]=nums[k++];
                even+=2;
              
            }
            else{
                arr[odd]=nums[k++];
                odd+=2;
            }
        }
        return arr;
    }

}