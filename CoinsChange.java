// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    private Integer[] memo;
    public int coinChange(int[] coins, int amount) {
       int[] dp = new int[amount+1];
       Arrays.fill(dp, amount+1);

       dp[0] = 0;
       for(int i=0;i<=amount;i++){
          for(int coin:coins){
              if(i - coin < 0) continue;
              dp[i] = Math.min(dp[i],dp[i - coin] +1);
          }
       }
       return dp[amount] == (amount+1) ? -1:dp[amount];
       }
}
