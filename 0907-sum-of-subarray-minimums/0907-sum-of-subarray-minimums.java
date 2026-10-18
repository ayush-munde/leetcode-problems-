class Solution {

    public int[] psn(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] span = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = -1;
            } else {
                span[i] = s.peek();
            }

            s.push(i);
        }

        return span;
    }

    public int[] nsn(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] span = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = arr.length;
            } else {
                span[i] = s.peek();
            }

            s.push(i);
        }

        return span;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] ps = psn(arr);
        int[] ns = nsn(arr);

        int mod = (int) 1e9 + 7;
        long total = 0;

        for (int i = 0; i < n; i++) {
            long left = i - ps[i];
            long right = ns[i] - i;

            total = (total + left * right * arr[i]) % mod;
        }

        return (int) total;
    }
}