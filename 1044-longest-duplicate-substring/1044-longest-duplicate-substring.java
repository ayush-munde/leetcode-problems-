
import java.util.*;

class Solution {
    public long[] hash1;
    public long[] hash2;
    public long[] power1;
    public long[] power2;

    public long base = 911382L;
    public long mod1 = 1000000007L;
    public long mod2 = 1000000009L;

    public Solution() {
    }

    public Solution(String s) {
        int n = s.length();

        hash1 = new long[n + 1];
        hash2 = new long[n + 1];
        power1 = new long[n + 1];
        power2 = new long[n + 1];

        power1[0] = 1;
        power2[0] = 1;

        for (int i = 0; i < n; i++) {
            int value = s.charAt(i);

            hash1[i + 1] =
                (hash1[i] * base + value) % mod1;

            hash2[i + 1] =
                (hash2[i] * base + value) % mod2;

            power1[i + 1] =
                (power1[i] * base) % mod1;

            power2[i + 1] =
                (power2[i] * base) % mod2;
        }
    }

    // Returns hash of substring [left, right)
    public long[] gethash(int left, int right) {
        long x1 = (hash1[right]
                - hash1[left] * power1[right - left] % mod1
                + mod1) % mod1;

        long x2 = (hash2[right]
                - hash2[left] * power2[right - left] % mod2
                + mod2) % mod2;

        return new long[]{x1, x2};
    }

    public int duplicateLength(String s, int length,
                               Solution sol) {

        if (length <= 0) {
            return -1;
        }

        int n = s.length();

        Map<String, List<Integer>> seen = new HashMap<>();

        for (int i = 0; i + length <= n; i++) {

            long[] current = sol.gethash(i, i + length);
            String key = current[0] + "#" + current[1];

            if (seen.containsKey(key)) {
                for (int previous : seen.get(key)) {

                    if (s.regionMatches(previous, s,
                                        i, length)) {
                        return i;
                    }
                }
            }

            seen.computeIfAbsent(key,
                k -> new ArrayList<>()).add(i);
        }

        return -1;
    }

    public String longestDupSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }

        int low = 1;
        int high = s.length() - 1;

        int beststart = -1;
        int bestlength = 0;

        Solution sol = new Solution(s);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int start = duplicateLength(s, mid, sol);

            if (start != -1) {
                beststart = start;
                bestlength = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (beststart == -1) {
            return "";
        }

        return s.substring(beststart,
                           beststart + bestlength);
    }
}
