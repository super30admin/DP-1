// Time complexity:o(n)
// space complexity:O(m*n)
// approach: create a matrix table with all the coins and the amount that can be made when we go to the next denomination we have to cases to take that coin or not take then fing the min of both cases that is the min coins
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m=amount;
        int n=coins.length;
        int [][] dp= new int[n+1][m+1];
        dp[0][0]=0;
        for(int j=0;j<=m;j++){
            dp[0][j]=99999;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(j < coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                } else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int re=dp[n][m];
        if(re>=99999) return -1;
        return re;

    }
}