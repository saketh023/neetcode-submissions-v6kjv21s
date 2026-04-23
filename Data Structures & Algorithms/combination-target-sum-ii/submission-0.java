class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, target, nums, currList);
        return result;
    }

    public void backtrack(int index, int target, int[] nums, List<Integer> currList){
        // stop when target < 0 break, or nums[i] > target continue
        if(target == 0){
            result.add(new ArrayList<>(currList));
            return;
        }

        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i] == nums[i-1]) continue;
            if(nums[i]>target) break;
            currList.add(nums[i]);
            backtrack(i+1, target - nums[i], nums, currList);
            currList.remove(currList.size()-1);
        }
    }
}
