class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char a : s.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // Get all unique characters
        List<Character> list = new ArrayList<>(map.keySet());

        // Sort by frequency in descending order
        list.sort((a, b) -> {
            return map.get(b) - map.get(a);
        });

        // Build answer
        StringBuilder result = new StringBuilder();

        for (char ch : list) {
            for (int i = 0; i < map.get(ch); i++) {
                result.append(ch);
            }
        }

        return result.toString();
        
    }
}