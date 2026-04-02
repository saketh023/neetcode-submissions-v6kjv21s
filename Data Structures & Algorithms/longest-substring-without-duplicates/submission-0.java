class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int result = 0;

        for(int right=0; right<chars.length; right++){
            while(set.contains(chars[right])){
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            result=Math.max(result, right-left+1);
        }

        return result;
    }
}
