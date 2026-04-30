class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(Integer.toString(str.length()));
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        // char[] chars = str.toCharArray();

        int i=0;

        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int wordLen = Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+wordLen;
            result.add(str.substring(i,j));
            i=j;
        }
        return result;
    }
}
