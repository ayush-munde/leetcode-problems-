class Solution {
    public int[] lps (String s){
        int n=s.length();
        int lps[]=new int[n];
        int len=0;
        int i=1;
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0)
                len=lps[len-1];

            
            else{
                lps[i]=0;
                i++;
            }
            }
        }
        return lps;
    }
    public List<Integer> kmp (String s,String pattern){
        int n=s.length();
        int m=pattern.length();
        int []lps=lps(pattern);
        int i=0,j=0;
        List<Integer> ans= new ArrayList<>();
        while(i<n){
            if(s.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
            if (j == m) {
                ans.add(i - j);

                j = lps[j - 1];
            }
            else if (i<n && s.charAt(i)!=pattern.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return ans;

    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n=s.length();
       
        List<Integer> aindex =kmp(s,a);
          List<Integer> bindex =kmp(s,b);
        ArrayList<Integer> res=new ArrayList<>();
          for(int i:aindex){
            for(int j:bindex){
                if(Math.abs(i-j)<=k){
                    res.add(i);
                    break;
                }
            }
          }
        
     

        return res;
    }
}