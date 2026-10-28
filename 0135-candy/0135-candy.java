class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candiate = new int[n];

        Arrays.fill(candiate, 1);

        // Left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candiate[i] = candiate[i-1] + 1;
            }
        }

        // Right to left
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candiate[i] = Math.max(
                    candiate[i],
                    candiate[i+1] + 1
                );
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candiate[i];
        }

        return sum;
    }
}