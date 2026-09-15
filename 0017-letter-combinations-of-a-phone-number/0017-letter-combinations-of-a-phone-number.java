class Solution {
        private final String[] map;
        public Solution() {
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
    public void helper(int index, String digits ,List<String> ans ,String curr){
        if(index==digits.length()){
            ans.add(curr);
            return ;
        }
        String s=map[digits.charAt(index)-'0'];
        for(int i=0;i<s.length();i++){
                   helper(index+1,digits, ans, curr+s.charAt(i));
        }
    }
    public List<String> letterCombinations(String digits) {
       List<String> ans= new ArrayList<>();
       helper(0,digits, ans, "");
       return ans;

        
    }
}