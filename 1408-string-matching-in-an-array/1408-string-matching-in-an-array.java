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
    public int kmp (String st,String p){
        String s;
        String pattern;
       
        if(st.length()<=p.length()){
            s=p;
         pattern=st;

            
        }
        else {
            s=st;
            pattern=p;

        }
         int n=s.length();
        int m=pattern.length();
        int []lps=lps(pattern);
        int i=0,j=0;
       
        while(i<n){
            if(s.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
            if (j == m) {
                return i-j;

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
        return -1;

    }
   public List<String> stringMatching(String[] words) {

    List<String> ans = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {

        for (int j = 0; j < words.length; j++) {

            if (i == j) continue;

            String s = words[j];
            String pattern = words[i];

            if (s.length() < pattern.length()) {
                continue;
            }

            if (kmp(s, pattern) != -1) {
                ans.add(pattern);
                break;
            }
        }
    }

    return ans;
}
}