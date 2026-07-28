

class Solution {

    public void find(int[] arr, int ind, List<Integer> ds,List<List<Integer>> ans, int target) {

            if (target == 0) {
                ans.add(new ArrayList<>(ds));
                 return;
            }
           
        

        // Pick the current element
        for(int i=ind;i<arr.length;i++){
             if(i>ind && arr[i]==arr[i-1]) continue;
             if(target<arr[i])    break; 
            ds.add(arr[i]);
            find(arr,i+1, ds, ans, target - arr[i]); // stay at same index
            ds.remove(ds.size() - 1); // backtrack
        
        }
       

       
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
     Arrays.sort(candidates);
        find(candidates, 0, ds, ans, target);

        return ans;
    }
}