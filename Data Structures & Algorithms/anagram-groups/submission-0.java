class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            String freqKey = getFreqKey(str);
            map.putIfAbsent(freqKey, new ArrayList<>());
            map.get(freqKey).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public String getFreqKey(String str){
        int[] freq = new int[26];
        for(char c : str.toCharArray()){
            freq[c-'a']++;
        }
        return Arrays.toString(freq);
    }
}
