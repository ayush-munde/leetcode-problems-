import java.util.*;

class Solution {

    public void find(int[] arr, int ind, List<Integer> ds,
                     List<List<Integer>> ans, int target) {

        // Base case
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // Pick the current element
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            find(arr, ind, ds, ans, target - arr[ind]); // stay at same index
            ds.remove(ds.size() - 1); // backtrack
        }

        // Don't pick the current element
        find(arr, ind + 1, ds, ans, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        find(candidates, 0, ds, ans, target);

        return ans;
    }
}