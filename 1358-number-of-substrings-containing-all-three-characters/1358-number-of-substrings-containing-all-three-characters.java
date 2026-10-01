class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int left=0;
        if(n<3) return -1;

          int freq[]=new int[3];
            for (int j = left; j < n; j++) {

                freq[s.charAt(j)-'a']++;
                while(freq[0]>0 && freq[1]>0 &&  freq[2]>0  ){
                    count+=n-j;
                    freq[s.charAt(left)-'a']--;
                    left++;
                }
              

        }

        return count;
    }
}