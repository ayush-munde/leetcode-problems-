class Solution {
    public int totalFruit(int[] fruits) {
        int left=0,right=0;
        int maxLeg=0;
        int n=fruits.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(right<n){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            if(map.size()>2){
                 map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);
                 if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                 }
                 left++;
                 }

            if(map.size()<=2){
                maxLeg=Math.max(maxLeg,(right-left+1));
        }
        right++;
            }
            return maxLeg;
        
    }
}