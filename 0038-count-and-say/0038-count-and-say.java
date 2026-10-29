class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        StringBuilder ps = new StringBuilder();
        ps.append(1);

        int i = 1;

        while (i < n) {
            StringBuilder ss = new StringBuilder();

            char ch = ps.charAt(0);
            int count = 0;

            for (int j = 0; j < ps.length(); j++) {
                if (ch == ps.charAt(j)) {
                    count++;
                } else {
                    ss.append(count);
                    ss.append(ch);

                    count = 1;
                    ch = ps.charAt(j);
                }
            }

            ss.append(count);
            ss.append(ch);

            ps = ss;
            i++;
        }

        return ps.toString();
    }
}