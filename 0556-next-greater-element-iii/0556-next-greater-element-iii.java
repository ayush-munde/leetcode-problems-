class Solution {
    public void reverse(char digits[],int start,int end){
        while(start<end){
                  swap(digits,start,end);
                  start++;

                  end--;
        }
    }
    public void swap(char digits[],int start,int end){
        char temp=digits[start];
         digits[start]=digits[end];
         digits[end]=temp;


    }
    public int nextGreaterElement(int n) {
        char[] digits=String.valueOf(n).toCharArray();
       int i=digits.length-2;
       while(i>=0 && digits[i]>=digits[i+1]){
        i--;
       }
       if(i==-1) return -1;
       int j=digits.length-1;
       while(digits[j]<=digits[i]){
        j--;
       }
       swap(digits,i,j);
       reverse(digits,i+1,digits.length-1);

       long ans=Long.parseLong(new String(digits));

       if(ans>Integer.MAX_VALUE) return -1;
       return (int)ans;

        
    
    }
    
}