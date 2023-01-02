// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int[m+1][n+1];
        for(int j = 1; j <= n; j++){
            dp[0][j] = 999999 ;
        }for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m][n]>=999999) return -1;
        return dp[m][n];
    }
}

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        //check if array is null
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if(n == 1) return nums[0];
        int [] dp = new int[n];
        //we will consider only two vatiables prev and curr and not whole array
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            //storing curr in temp since we need to assign it to prev and it will change later
            int temp = curr;
            //calculate curr
            curr = Math.max(curr, nums[i]+prev);
            //shift prev to curr
            prev = temp;
        } return curr;
    }
}
