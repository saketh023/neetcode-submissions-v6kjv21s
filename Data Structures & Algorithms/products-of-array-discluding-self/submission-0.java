class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0]=1;
        for(int i=1; i<nums.length; i++){
            result[i] = nums[i-1]*result[i-1];
        }

        int temp = 1;
        for(int j = nums.length-2; j>=0; j--){
            temp = temp * nums[j+1];
            result[j] = temp * result[j];
        }
        return result;
    }
}  
