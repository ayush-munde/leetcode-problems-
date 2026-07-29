class Solution {
    public int[] findErrorNums(int[] nums) {
       
                long  n=nums.length;
          long expectSum=(n*(n+1))/2;
        long expectSSum=(n*(n+1)*(2*n+1))/6;
        long  actualSum=0;
        long actualSSum=0;
        for(int num:nums){
            actualSum+=num;
            actualSSum+=(num)*(num);

        }
        long diff=actualSum-expectSum;
        long sdiff=actualSSum-expectSSum;
        long a=sdiff/diff;
        int rep=(int)((diff+a)/2);
        int miss=(int)(a-rep);
       
         return new int[]{rep,miss};
    }
}