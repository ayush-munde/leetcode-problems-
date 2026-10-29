class Solution {
    public int jump(int[] nums) {
        int furthest=0;
        int jump=0;
        int currentEnd=0;

       int n=nums.length;
       for(int i=0;i<n-1;i++){
        furthest=Math.max(furthest,i+nums[i]);
        if(i==currentEnd){
            jump++;
            currentEnd=furthest;
        }
       }
      
          
           

        return jump;
    }
}