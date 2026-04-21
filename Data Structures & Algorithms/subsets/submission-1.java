class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        dfs(0, nums, currList);
        return result;
    }

    public void dfs(int i, int[] nums, List<Integer> currList){
        if(i>=nums.length){
            result.add(new ArrayList<>(currList));
            return;
        }
        currList.add(nums[i]);
        dfs(i+1, nums, currList);
        currList.remove(currList.size()-1);
        dfs(i+1, nums, currList);
    }
}
