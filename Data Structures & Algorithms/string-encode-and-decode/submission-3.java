class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int wordLen = Integer.parseInt(str.substring(i, j));
            String curr = str.substring(j + 1, j + 1 + wordLen);
            result.add(curr);
            i = j + 1 + wordLen;

        }
        return result;
    }
}
