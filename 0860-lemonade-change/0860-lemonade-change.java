class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0]!=5){
            return false;
        }
         int five=0;
         int ten=0;
              for(int i=0;i<bills.length;i++){
        if(bills[i]==10 && five>0){
           ten++;
 five--;

        }
        else  if(bills[i]==20){
        if ( ten>=1&& five>=1){
             five--;
             ten--;
        }
        else if(five>=3){
               five-=3;
        }
        else return false;


        }
       else  if(bills[i]==5 ){
        five++;
        
    }
    else{
        return false;
    }
    
       }
       return true;
    }
}