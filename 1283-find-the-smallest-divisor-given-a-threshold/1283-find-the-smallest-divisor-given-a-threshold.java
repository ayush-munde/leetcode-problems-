class Solution {
    public int find(int[] nums, int k){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]+k-1)/k;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=Arrays.stream(nums).max().getAsInt();
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(find(nums,mid)<=threshold){
                ans=mid;
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        return ans;
        
    }
}