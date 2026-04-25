class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(int num : nums){
            if(hs.add(num)){
                continue;
            }
            return true;
        }
        return false;
    }
}