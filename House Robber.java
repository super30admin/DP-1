// TC is O(n) where n is the number of houses
// SC is O(n) as new array is used

class Solution {
    public int rob(int[] nums) {
        //null
        if(nums == null || nums.length==0)return 0;
        int n = nums.length;
        int[] dp = new int[n];
        if(n<2)return nums[0];
        int previous =nums[0];
        int current = Math.max(nums[0],nums[1]);
        for(int i = 2; i<nums.length;i++){
//dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
            int temp = current;
            current = Math.max(previous + nums[i],temp);
            previous = temp;
        }
        return current;
    }
}