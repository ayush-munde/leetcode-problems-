class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int n = s.length();
        int max = 0;

        while (j < n) {

            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }

            map.put(s.charAt(j), j);

            j++;

            int len = j - i;

            if (max < len) {
                max = len;
            }
        }

        return max;
    }
}