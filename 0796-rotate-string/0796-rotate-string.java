class Solution {
    public int[]lps(String s){
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
            else {
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
    public boolean rotateString(String s, String goal) {
           if (s.length() != goal.length()) {
            // Return false if lengths don't match
            return false;
        }
        if(s.isEmpty())
        return true;
         String a=s+s;
        int lps[]=lps((goal));
        int i=0;
        int j=0;
        while(i<a.length()){
            if(a.charAt(i)==goal.charAt(j)){
                i++;
                j++;
            }
            if(j==goal.length()){
                return true;
            }
            if(i<a.length() && a.charAt(i)!=goal.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }

        }
      
    
    return false;
    }
}