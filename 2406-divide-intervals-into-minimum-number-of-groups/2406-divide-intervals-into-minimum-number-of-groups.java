class Solution {
    public int minGroups(int[][] intervals) {
       PriorityQueue<Integer> pq =new PriorityQueue<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        pq.add(intervals[0][1]);

        
        for(int i=1;i<intervals.length;i++){
            if(pq.peek()<intervals[i][0]){
                pq.poll();
              
            }
            else{
        
            }
              pq.add(intervals[i][1]);
            
        
          
        }
        return pq.size();




        
    }
}