class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
    
        int curr=0;
        if(k==0){
            return -1;
        }
        if(k==n){
            int total=0;
            for(int i=0;i<n;i++){
                            total+=cardPoints[i];
            }
            return total;
        }
        for(int i=0;i<k;i++){
             curr+=cardPoints[i];
        }
        int right=n-1;
           int maxSum=curr;

           for(int i=k-1;i>=0;i--){
            curr-=cardPoints[i];
            curr+=cardPoints[right];
            right--;
            if(curr>maxSum){
                maxSum=curr;
            }
           }

  return maxSum;
        
    }
}