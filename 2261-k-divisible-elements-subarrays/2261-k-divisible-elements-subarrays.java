class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n=nums.length;
        Set<List<Integer>> ans=new HashSet<>();
        for(int i=0;i<n;i++){
              int count=k;
                ArrayList<Integer> list=new ArrayList<>();
            for(int j=i;j<n;j++){
               
              
                list.add(nums[j]);

                if(nums[j]%p==0){
                    count--;
                }
                if(count<0 ){
                    break;
                }
                if(count>=0)
                ans.add(new ArrayList(list));
            }
        }
        return ans.size();
    }
}