
class Solution {
    public String subStrHash(String s, int power, int modulo,
                             int k, int hashValue) {

        int n = s.length();
        long hash = 0;
        long pk = 1;
        int index = 0;

        // Calculate power^k
        for (int i = 0; i < k; i++) {
            pk = (pk * power) % modulo;
        }

        for (int i = n - 1; i >= 0; i--) {

            hash = (hash * power + (s.charAt(i) - 'a' + 1))
                   % modulo;

            if (i + k < n) {
                hash = (hash -
                       (s.charAt(i + k) - 'a' + 1) * pk % modulo
                       + modulo) % modulo;
            }

            if (i + k <= n && hash == hashValue) {
                index = i;
            }
        }

        return s.substring(index, index + k);
    }
}