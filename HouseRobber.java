// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes 
class HouseRobber{
    public int rob(int[] nums){
        int n = nums.length;
        int dp[] = new int[n];
        if(nums.length < 2) return nums[0]
        dp[0] = nums[0]; // Saving first and second element from array.
        dp[1] = Math.max(nums[0], nums[1]);

        for(int = 2; i< n; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]); //Zeroth case lies one step back, one step lies two stepback.
        }
        return dp[n-1];
    }
}