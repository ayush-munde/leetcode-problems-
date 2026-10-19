class Solution {
     public int[] ngn(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] span = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()]<= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] =arr.length;
            } else {
                span[i] = s.peek();
            }

            s.push(i);
        }

        return span;
    }
        public int[] pgn(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] span = new int[arr.length];

        for (int i =0; i<arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()]<arr[i]) {
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
            while (!s.isEmpty() && arr[s.peek()]>= arr[i]) {
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
      public int[] psn(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] span = new int[arr.length];

        for (int i = 0; i < arr.length ; i++) {
            while (!s.isEmpty() && arr[s.peek()]>arr[i]) {
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
    public long subArrayRanges(int[] nums) {
        int []ng=ngn(nums);
        int [] pg=pgn(nums);
         int []ns=nsn(nums);
        int [] ps=psn(nums);
       long max=0,min=0;
        for(int i=0;i<nums.length;i++){
            max+=(long)nums[i]*(ng[i]-i)*(i-pg[i]);
            min+=(long)nums[i]*(ns[i]-i)*(i-ps[i]);
        }
        return max-min;
    }
}