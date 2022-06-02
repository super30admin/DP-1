class Solution {
    //Time complexity: O(number of coins*total amount)
    //Space complexity: O(total amount)
    public int coinChange(int[] coins, int amount) {
        int m=coins.length+1;
        int n=amount+1;
        int[][] dp=new int[m][n];
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=amount+1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[m-1][n-1]==amount+1)
            return -1;
        return dp[m-1][n-1];
    }
}