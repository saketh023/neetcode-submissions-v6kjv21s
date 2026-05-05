class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(target, currList, 0, nums);
        return result;
    }

    public void backtrack(int sum, List<Integer> currList, int i, int[] nums){
        if(sum < 0) return;
        if(sum == 0){
            result.add(new ArrayList<>(currList));
            return;
        }
        for(int index = i; index < nums.length; index++){
            currList.add(nums[index]);
            backtrack(sum - nums[index], currList, index, nums);
            currList.remove(currList.size()-1);
        }
    }
}
