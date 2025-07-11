class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = amount; //number of rows
        int n = coins.length; //number of columns
        int dp[][] = new int[n+1][m+1]; //m+1 : extra row for dummy denomination
        dp[0][0] = 0; //0 coins are needed to make amount 0
        //setting top row to infinity 
        for(int j = 1 ; j <= m ; j++){
            dp[0][j] = Integer.MAX_VALUE - 10; 
        }
        for(int i = 1 ; i <= n ; i++){ //start filling values from row 1
           for(int j = 1 ; j <= m ; j++){
            //till amount <= denomination of current coin 
            if(j < coins[i-1]){   // coins[] is 0-based, but dp starts from 1 ,i-1 maps dp row to correct coin
 
                dp[i][j] = dp[i-1][j];
            }
            else{
                dp[i][j] = Math.min(dp[i-1][j] , 1+ dp[i][j-coins[i-1]]);
            }
           } 
        }
        if(dp[n][m] >= Integer.MAX_VALUE - 10){
            return -1;
        }
        return dp[coins.length][amount];


        
        
    }
}