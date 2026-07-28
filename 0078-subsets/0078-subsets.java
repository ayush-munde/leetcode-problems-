import java.util.*;

class Solution {

    public void set(int[] arr, List<Integer> s,
                    List<List<Integer>> ans, int i) {

        if (i == arr.length) {
            ans.add(new ArrayList<>(s));
            return;
        }

        // Pick
        s.add(arr[i]);
        set(arr, s, ans, i + 1);

        // Backtrack
        s.remove(s.size() - 1);

        // Not Pick
        set(arr, s, ans, i + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        set(nums, new ArrayList<>(), ans, 0);

        return ans;
    }
}