class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> currList = new ArrayList<>();
        backtrack(0, currList, nums);
        return result;
    }

    public void backtrack(int i, List<Integer> subset, int[] nums){
        if(nums.length == i){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(i+1, subset, nums);
        subset.remove(subset.size()-1);

        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        backtrack(i+1, subset, nums);
    }
}
