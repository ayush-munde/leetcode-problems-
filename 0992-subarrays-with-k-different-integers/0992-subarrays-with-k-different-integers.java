class Solution {
    public int helper(int [] nums,int k){
        if(k<=0) return 0;

        int left=0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<nums.length;j++){
            int val=nums[j];
            map.put(val,map.getOrDefault(val,0)+1);
            while(map.size()>k){
                  int leftval=nums[left];
                     map.put(leftval,map.getOrDefault(leftval,0)-1);
                     if(map.get(leftval)==0){
                             map.remove(leftval);
                     }
                     left++;
            }
            count+=j-left+1;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        if(k<=0) return 0;
        return helper(nums,k)-helper(nums,k-1);
        
    }
}