class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i=nums.length-1; i >=0; i--){
            dp[i] = 1 + computeNextValues(i,nums,dp);
        }

        int max = 0;
        for(int i=0; i<dp.length;i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    public int computeNextValues(int i, int[] nums, int[] dp){
        int nextValues = 0;
        for(int j=i+1; j < nums.length; j++){
            if(nums[i] < nums[j]){
                nextValues = Math.max(nextValues,dp[j]);
            }
        }
        return nextValues;
    }
}
