class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        List<Integer> currList = new ArrayList<>();
        backtrack(nums, freq, currList);
        return result;
    }

    public void backtrack(int[] nums, boolean[] freq, List<Integer> currList){
        if (currList.size() == nums.length) {
            result.add(new ArrayList<>(currList));
            return;
        }
        for(int i=0; i<nums.length;i++){
            if(!freq[i]){
                currList.add(nums[i]);
                freq[i] = true;
                backtrack(nums, freq, currList);
                currList.remove(currList.size()-1);
                freq[i] = false;
            }
        }
    }
}
