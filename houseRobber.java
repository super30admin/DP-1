//Time complexity: O(n) || I am not sure but I think the longest recursive call branch would be length n
//Space complexity: O(1)
//Program ran successfully
/*  Algorithm: 1. The recursive call compares the maximum amount by exploring all sub paths 
               2. In each case, we either chose the element(or that path) or select the adjacent element
               3. The repeating calls are memoized using a dp array
               4. maximum amount is returned
*/

class houseRobber {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1); 
        int max = dp(nums,n);
        return max;
    }
    private int dp(int[] nums, int n){
        if(n <= 0){
            return 0;
        }
        if(dp[n-1] != -1) return dp[n-1];
        dp[n-1] = Math.max(nums[n-1]+dp(nums,n-2), dp(nums,n-1)); 
        return dp[n-1];
    }
} 
