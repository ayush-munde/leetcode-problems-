
        class Solution {
            public int[] LPS(String pattern){
                int n=pattern.length();
                int len=0;
                int i=1;
                int[] lps=new int[n];
                while(i<n){
                    if(pattern.charAt(i)==pattern.charAt(len)){
                        len++;
                        lps[i]=len;
                        i++;
                    }

                    else{
                        if(len!=0){
                            len=lps[len-1];
                        }
                        else{
                            lps[i]=0;
                            i++;
                        }
                    }
                }
                return lps;
            }
    public int strStr(String haystack, String needle) {
         int n=haystack.length();
         int  m=needle.length();
         int lps[]=LPS(needle);
         int i=0;

         int j=0;
         while(i<n){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
        
            if(j==m){
                return i-j;
            }
         }
            else{
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i++;

                }
            
         }
         }
         return-1;
    }
}
        
   