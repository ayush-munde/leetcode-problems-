class Solution {
    public int maxArea(int[] height) {
        int  left=height[0];
        int right=height[height.length-1];
        int  i=0,j=height.length-1;
        int waterlevel=0,maxLevel=0;
        while(i<j){
            left=Math.max(left,height[i]);
            right=Math.max(right,height[j]);
            waterlevel=Math.min(left,right)*(j-i);
            maxLevel=Math.max(waterlevel,maxLevel);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxLevel;
        
    }
}