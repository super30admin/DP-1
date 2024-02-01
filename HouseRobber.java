//time complexity-O(n), space complexity - O(n)
//function uses bottom-up method to fill dp array.
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for(int i=n-1;i>=0;i--){
            dp[i] = Math.max(nums[i]+dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}