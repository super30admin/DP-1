//Time complexity is O(N)
//Space complexity is O(N)
//Able to submit in leetcode
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 10001);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
    return dp[amount] > amount ? -1 : dp[amount];
    }
}