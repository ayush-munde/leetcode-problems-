class Solution {
    public int trap(int[] h) {

       int water=0;
       int waterlevel=0;
       Stack<Integer> s=new Stack<>();
       for(int i=0;i<h.length;i++){
        while(!s.isEmpty() && h[i]>h[s.peek()]){
            int bottom=s.pop();
            if(s.isEmpty()) break;
            int left=h[s.peek()];
            int right=h[i];
            int width=i-s.peek()-1;
            int height=Math.min(left,right)-h[bottom];
            water+=width*height;

        }
        s.push(i);
      
       }
         return water;
    }
}
