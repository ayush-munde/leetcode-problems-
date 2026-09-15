class Solution {
  public void   Generate(String curr, List<String> result, int n,int open ,int close){
    if(curr.length()==2*n){
        result.add(curr);
        return;
    }
     if(open<n) Generate(curr+'(',result,n,open+1,close);
     if(close<open) Generate(curr+')',result,n,open,close+1);
  }
    public List<String> generateParenthesis(int n) {
        List<String> result =new ArrayList<>();
       

       Generate("",result,n,0,0);
       return result;
        
    }
}