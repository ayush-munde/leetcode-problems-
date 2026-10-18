class Solution {
    public int[] nextGreaterElements(int[] nums){
        int n=nums.length;
        Stack<Integer> s=new Stack<>();
        int span[]=new int[n];
        for(int i=n-1;i>=0;i--){
           
             s.push(nums[i]);
   }

        for(int i=n-1;i>=0;i--){
             while(!s.isEmpty() && s.peek()<=nums[i]){
                 s.pop();
            }
            if(s.isEmpty()){
                span[i]=-1;
            }
            else{
                 span[i]=s.peek();
            }
            s.push(nums[i]);
        }


        return span;
        
    }
}