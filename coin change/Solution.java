// Time complexity = O(n^2)
// space comlpexity = O(amount+1)

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        if(coins.length==0 || amount <=0) return -1;
        int []dp=new int[amount+1];
        for(int i=0;i<amount+1;i++){
            dp[i]=amount+1;
        }
        dp[0]=0;
        for(int i=1;i<amount+1;i++){
            for(int c=0;c<coins.length;c++){
                if(i-coins[c]>=0){
                    dp[i]=Math.min(dp[i],1+dp[i-coins[c]]);
                }
            }
        }
        if(dp[amount]!=amount+1) return dp[amount];
        return -1;
    }
}
