class Solution {
    public String reverseWords(String s) {

        String a = s.trim();
    String[] arr = s.trim().split("\\s+");

        String b = "";

        for (int i = arr.length - 1; i >= 0; i--) {
          
            b = b + arr[i] + " ";
        }

        return b.trim();
    }
}