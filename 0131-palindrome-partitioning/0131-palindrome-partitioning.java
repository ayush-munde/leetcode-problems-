class Solution {
  
    public void dptable(String s,int[][] dp,int i){
           if(i<0){
          
            return;
        }
        for(int j=i;j<s.length();j++){
            if(i==j){
                dp[i][j]=1;
            }
            else if(j-i==1 && s.charAt(i)==s.charAt(j)){
                dp[i][j]=1;   
            }


            
            else if(dp[i+1][j-1]==1 && s.charAt(i)==s.charAt(j)){
                dp[i][j]=1;
            }
            else{
                dp[i][j]=0;
            }
        }
        dptable(s,dp,i-1);


      
    }
    public void checkpartition(String s,int i,int dp[][],List<String> ans,List<List<String>>list){
        if(i==s.length()){
            list.add(new ArrayList<String>(ans));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(dp[i][j]==1){
                ans.add(s.substring(i,j+1));
                 checkpartition(s,j+1,dp,ans,list);
                 ans.remove(ans.size()-1);

            }

            }
        

        }
        

    
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
            int n=s.length();
        int dp[][]=new int[n][n];
        dptable(s,dp,n-1);
    
        checkpartition(s,0,dp,new ArrayList<>(),list);
        return list;
        
    }
}