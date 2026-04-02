class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0; 
        int right = nums.length-1;
        int currSum = 0;

        while(left<right){
            currSum = nums[left]+nums[right];
            if(currSum == target) return new int[]{left+1, right+1};
            else if(currSum>target){
                right--;
            }else{
                left++;
            }
        }
        return null;
    }
}