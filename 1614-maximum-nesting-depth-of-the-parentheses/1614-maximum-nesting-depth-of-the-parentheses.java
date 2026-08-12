class Solution {
    public int maxDepth(String s) {
        
        int p=0;
        int ans=0;
        for(char a: s.toCharArray()){
            if(a=='(')p++;
            else if(a==')')p--;
            ans=Math.max(ans,p);
        }
        return ans;
    }
}