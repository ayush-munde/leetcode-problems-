class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
       int seq=1;
    int  seq1=1;
    if(nums.length==0)
    return 0;
        for(int i=0;i<nums.length-1;i++){
               if(nums[i+1]==nums[i]){
                continue;
               }

            if((nums[i+1]-nums[i]!=1)){
                seq=Math.max(seq,seq1);
                seq1=1;
                continue;
            
            }
           else  seq1++;



        }
         seq=Math.max(seq,seq1);
        return seq;


    
        
    }
}