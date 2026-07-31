class Solution {
    public boolean find(int[] bloom ,int m,int k,int day){
        int count=0;
        int bq=0;
        for(int i=0;i<bloom.length;i++){
            if(bloom[i]<=day){
                count++;
            }
            else{
                bq+=(count/k);
                count=0;
            }
        }
          bq+=(count/k);

        if(m<=bq){
            return true;
        }
        return false;

    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low=Arrays.stream(bloomDay).min().getAsInt();
         int high=Arrays.stream(bloomDay).max().getAsInt();
         int ans=-1;
         while(low<=high){
            int mid=(low+high)/2;
            if(find(bloomDay,m,k,mid)){
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