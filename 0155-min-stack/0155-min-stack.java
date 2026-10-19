class MinStack {
   Stack<Integer> s1;
      Stack<Integer> s2;
      int min=Integer.MAX_VALUE;
    public MinStack() {
        s1=new Stack<>();
        s2=new Stack<>();
        
    }
    
    public void push(int value) {
        s1.push(value);
        if(min>=value){
            s2.push(value);
            min=value;

        }

        
    }
    
    public void pop() {
       int val= s1.pop();
       if(val==min){
           s2.pop();
         if(!s2.isEmpty())  min=s2.peek();
         else
          min=Integer.MAX_VALUE;
           
       }
        
        
    }
    
    public int top() {
        return s1.peek();
        
    }
    
    public int getMin() {
           return min;
        }
        
    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */