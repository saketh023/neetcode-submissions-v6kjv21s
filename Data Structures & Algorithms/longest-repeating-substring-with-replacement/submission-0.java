class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int left = 0;
        int result = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right<s.length(); right++){
            char currChar = s.charAt(right);
            map.put(currChar, map.getOrDefault(currChar, 0)+1);
            maxFreq = Math.max(map.get(currChar), maxFreq);

            while(right - left +1 - maxFreq > k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            result = Math.max(right - left+1, result);
        }
        return result;

    }
}
