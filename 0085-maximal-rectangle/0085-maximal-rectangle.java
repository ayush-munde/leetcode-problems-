class Solution {
    public int maxRectangle(int arr[]){
        int MaxArea=0;
        int n=arr.length;
      Stack<Integer> s=new Stack<>();
       for(int i=0;i<=n;i++){
        int currentheight=(i==n)?0:arr[i];
        while(!s.isEmpty() && currentheight<arr[s.peek()]){
            int h=arr[s.pop()];
            int width=s.isEmpty()?i:i-s.peek()-1;
            int Area=h*width;
            MaxArea=Math.max(MaxArea,Area);

        }
        s.push(i);

       }
       return MaxArea;
            
        
    }
    public int maximalRectangle(char[][] matrix) {
        int []arr=new int[matrix[0].length];
        int maxArea=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1') arr[j]++;
                else arr[j]=0;
               

            }
             int Area=maxRectangle(arr);
                maxArea=Math.max(maxArea,Area);
        }
        return maxArea;
    }
}