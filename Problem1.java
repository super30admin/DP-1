//Accepted at Lt
//So tried a lot before class but had no luck with it, after the class got the concept of dp and applied, the idea here is to follow a checklist identify a dp problem and store repeated sub problems 
//Time should be o(mn) i guess for filling the matrix 

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        Arrays.fill(dp[0],10001);
        dp[0][0]=0;
        for(int i =1;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }

            }
        } 
        int r = dp[m][n];
        if(r>=10001) return -1;

        return r;
    }
}