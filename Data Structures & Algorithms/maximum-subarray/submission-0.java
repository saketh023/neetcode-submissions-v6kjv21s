class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currSum < nums[right] && currSum < 0) {
                left = right;
                currSum = 0;
            }
            currSum += nums[right];
            right++;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}