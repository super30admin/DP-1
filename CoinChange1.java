public class CoinChange1 {

    //Time Coplexity-O(mn)
    //Space Complexity-O(mn)
    public int coinChange(int[] coins, int amount) {
        int m=coins.length;
        int n=amount;

        int[][] dp=new int[m+1][n+1];

        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=amount+1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }

        if(dp[m][n]>=amount+1){
            return -1;
        }

        return dp[m][n];
    }
}
