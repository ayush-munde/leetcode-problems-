class Solution {
     public int[] lps(int[] s) {
        int n = s.length;
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (s[i]== s[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
    public int kmp(int[] s, int[] pattern){
        int n=s.length;
        int m=pattern.length;
        int lps[]=lps(pattern);
        int j=0;
        int i=0;
        int count=0;
        while(i<n){
            if(s[i]==pattern[j]){
                i++;
                j++;
                
            }
            if(j==m)
            {
                count++;
                j=lps[j-1];
            }
            else if(i<n && s[i]!=pattern[j]){
                if(j!=0)
                  j=lps[j-1];
                else {
                    i++;
                }
            }
        }
        return count;

    }
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int [] check=new int[nums.length-1];
        int k=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                check[k++]=1;
            }
            else if(nums[i]<nums[i-1]){
                check[k++]=-1;
            }
            else{
                check[k++]=0;
            }


        }
        return kmp(check,pattern);

        
    }
}