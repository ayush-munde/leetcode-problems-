class Solution {
    public int find(int arr[],int cap){
        int load=0;
        int day=1;
        for(int i=0;i<arr.length;i++){
            if(load+arr[i]>cap){
                load=arr[i];
                day++;
            }
            else{
                load+=arr[i];
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
       int low=Arrays.stream(weights).max().getAsInt();
       int high=0;
       int a=Integer.MAX_VALUE;
       for(int i=0;i<weights.length;i++){
        high+=weights[i];
       }
       while(low<high){
        int mid=(low+high)/2;
        if(find(weights,mid)<=days){
           
            high=mid;
            
        }
        else {
            low=mid+1;
        }
      
       }
       return low;
    }
}