class Solution {
    public int search(int[] nums, int target) {
        return recursiveBinarySearch(nums, target, 0, nums.length-1);
    }

    public int recursiveBinarySearch(int[] nums, int target, int left, int right){
        if(left>right){
            return -1;
        }

        int mid = (left+right)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(target>nums[mid]){
            return recursiveBinarySearch(nums, target, mid+1, right);
        }else{
            return recursiveBinarySearch(nums, target, left, mid-1);
        }
    }
}