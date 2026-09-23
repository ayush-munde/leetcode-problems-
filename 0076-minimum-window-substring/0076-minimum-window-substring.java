class Solution {
    public String minWindow(String s, String t) {

        int i = 0, j = 0;

        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int start = -1;

        int[] freq = new int[256];

        for (int k = 0; k < t.length(); k++) {
            freq[t.charAt(k)]++;
        }

        while (j < s.length()) {

            if (freq[s.charAt(j)] > 0) {
                count++;
            }

            freq[s.charAt(j)]--;

            while (count == t.length()) {

                if ((j - i + 1) < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                freq[s.charAt(i)]++;

                if (freq[s.charAt(i)] > 0) {
                    count--;
                }

                i++;
            }

            j++;
        }

        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}