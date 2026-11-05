
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {
            ans.add(check(query, pattern));
        }

        return ans;
    }

    public boolean check(String query, String pattern) {
        int i = 0;
        int j = 0;

        while (i < query.length()) {
            char ch = query.charAt(i);

            if (j < pattern.length() && ch == pattern.charAt(j)) {
                j++;
            }
            else if (Character.isUpperCase(ch)) {
                return false;
            }

            i++;
        }

        return j == pattern.length();
    }
}
