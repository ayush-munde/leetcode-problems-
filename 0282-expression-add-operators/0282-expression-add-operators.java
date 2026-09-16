class Solution {
    public void DFS(List<String> result,int start, long current_val,long lastoperand,String expression ,String num,int target ){
        if(start==num.length()){
            if(current_val==target){
                result.add(expression);
            }
            return ;
        }
      for(int i=start;i<num.length();i++){
        if(i>start && num.charAt(start)=='0') return ;
          String current_num=num.substring(start,i+1);
          Long current_val_num=Long.parseLong(current_num);
          if(start==0){

            DFS(result,i+1,current_val_num,current_val_num, current_num ,num,target);
          }
          else{
              DFS(result,i+1,current_val+current_val_num,current_val_num, expression + '+' + current_num ,num,target);

                DFS(result,i+1,current_val-current_val_num,-current_val_num, expression + '-' + current_num ,num,target);
                  DFS(result,i+1,current_val-lastoperand + lastoperand*current_val_num,lastoperand*current_val_num, expression + '*' + current_num ,num,target);
          }


      }
      
    }
    public List<String> addOperators(String num, int target) {
        List<String> result =new ArrayList<>();
        DFS(result,0,0,0,"",num,target);
        return result;
    }
}