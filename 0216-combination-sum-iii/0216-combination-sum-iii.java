class Solution {
    public static void combine(List<Integer> temp,int ind, List<List<Integer>> ans, int sum,int k){
        if(sum==0 && temp.size()==k ){
            ans.add(new ArrayList(temp));
            return ;
        }
        if(sum<=0 || temp.size()>k) return ;
       
        for(int i=ind;i<=9;i++ ){
            if(i<=sum){
                temp.add(i);
                combine(temp,i+1,  ans,sum-i, k);
                temp.remove(temp.size()-1);

            }
            else{
                break;
            }
           

        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();

        combine( temp,1,  ans, n,k);
        return ans;
        
        
    }
}