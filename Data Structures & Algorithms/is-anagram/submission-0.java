class Solution {
    public boolean isAnagram(String s, String t) {
        int[] schars = new int[26];
        int[] tchars = new int[26];

        for(char c : s.toCharArray()){
            schars[c-'a']++;
        }
        for(char d : t.toCharArray()){
            tchars[d-'a']++;
        }

        return Arrays.equals(schars, tchars);
    }
}
