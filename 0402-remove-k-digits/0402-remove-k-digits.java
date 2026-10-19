
import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        int j = 0;
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            while (!s.isEmpty() &&
                   s.peek() > num.charAt(i) &&
                   j < k) {

                s.pop();
                j++;
            }

            s.push(num.charAt(i));
        }

        // Remove remaining digits
        while (j < k && !s.isEmpty()) {
            s.pop();
            j++;
        }

        // Construct the string
        StringBuilder sb = new StringBuilder();

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        sb.reverse();

     

      
        int i=0;
        while (i < sb.length() && sb.charAt(i) == '0') {
    i++;
}

         return i == sb.length() ? "0" : sb.substring(i).toString();
  
}
}
