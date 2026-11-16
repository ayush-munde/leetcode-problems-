class Solution {
    
    public int countDistinct(int[] nums, int k, int p) {
        int n=nums.length;
   long base1 = 2431L;
long mod1 = 1_000_080_007L;
         long base2 = 1999L;
long mod2 = 1_900_700_039L;
        long hash1;
           long hash2;
     
        Set<Long> ans=new HashSet<>();
        for(int i=0;i<n;i++){
              int count=k;
              hash1=0;
              hash2=0;
              for(int j=i;j<n;j++){
               
                if(nums[j]%p==0){
                    count--;
                }
                if(count<0){
                    break;
                }
                hash1=(hash1*base1+nums[j])%mod1;
                 hash2=(hash2*base2+nums[j])%mod2;
                ans.add(hash1 +'#'+ hash2);

              }
            

        }
        return ans.size();
        
    }
}