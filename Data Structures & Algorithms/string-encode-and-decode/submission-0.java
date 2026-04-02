class Solution {

 public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append("#").append(s);
        }
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            // Find the delimiter #
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j)); // Extract length
            j++; // Move past '#'
            res.add(str.substring(j, j + length)); // Extract the string
            i = j + length; // Move to the next segment
        }

        return res;
    }
}
