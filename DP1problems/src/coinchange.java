class coinchange {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length+1;
        int m=amount +1;
        //initializing DP Array.
        int [][] dp =new int[n][m];

        for(int j=0;j<m;j++){
            dp[0][j]= 99999;//Integer.MAX_VALUE (_)
        }
        for(int i=0;i<n;i++){
            dp[i][0]= 0;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(j < coins[i-1]){
                    dp[i][j]=dp[i-1][j];//writing above value
                }
                else{
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
            }
        }

        return dp[n-1][m-1]==99999 ? -1 :dp[n-1][m-1];
    }
}

//time complexity is O(n)