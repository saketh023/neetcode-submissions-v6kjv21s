class Solution {
    public boolean canPartition(int[] nums) {
        if(sum(nums) % 2 != 0){
            return false;
        }

        int target = sum(nums)/2;
        boolean[] dp = new boolean[target+1];
        boolean[] nextDp = new boolean[target+1];

        dp[0] = true;
        for(int i=0; i<nums.length; i++){
            for(int j=1; j <= target; j++){
                if(j >= nums[i]){
                    nextDp[j] = dp[j] || dp[j-nums[i]];
                }else{
                    nextDp[j] = dp[j];
                }
            }
            boolean[] temp = dp;
            dp = nextDp;
            nextDp = temp;
        }

        return dp[target];
    }

    public int sum(int[] nums){
        int res = 0;
        for(int num : nums){
            res+=num;
        }
        return res;
    }
}