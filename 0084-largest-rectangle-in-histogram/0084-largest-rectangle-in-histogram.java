class Solution {
      public int[] nsl(int[] h){
        int span[]=new int[h.length];
        Stack<Integer> s=new Stack<>();
        int i=0;
        while(i<h.length){
            while(!s.isEmpty() && h[s.peek()]>=h[i]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=-1;
            }
            else{
                span[i]=s.peek();
            }
            s.push(i);
             i++;

        }
        return span;
       

    }
    
      public int[] nsr(int[] h){
        int span[]=new int[h.length];
        Stack<Integer> s=new Stack<>();
        int i=h.length-1;
        while(i>=0){
            while(!s.isEmpty() && h[s.peek()]>=h[i]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=h.length;
            }
            else{
                span[i]=s.peek();
            }
            s.push(i);
             i--;

        }
        return span;
       

    }
  
    public int largestRectangleArea(int[] heights) {
        int nsl[]=nsl(heights);
        int nsr[]=nsr(heights);
        int largestArea=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
           
                int area=heights[i]*(nsr[i]-nsl[i]-1);
                largestArea=Math.max(largestArea,area);


            }
             return largestArea;


        }
       
        
    }
