class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(currList, 0, nums);
        return result;
    }

    public void backtrack(List<Integer> currList, int i, int[] nums){
        if(i == nums.length){
            result.add(new ArrayList<>(currList));
            return;
        }
        currList.add(nums[i]);
        backtrack(currList, i+1, nums);
        currList.remove(currList.size()-1);
        backtrack(currList, i+1, nums);
    }
}