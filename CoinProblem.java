class Solution {
    public int coinChange(int[] coins, int amount) {
        // null
        return helper(coins , 0 , amount, 0);
    }

    private int helper(int [] coins, int i , int amount , int coinsUsed){
        //base
        if(amount == 0) return coinsUsed;
       // if(amout < 0 || i <0) return coinsUsed;

        //logiv
        //choose the coin
        int case1= helper (coins, i, amount -coins[i] , coinsUsed +1);

        //if coin is not choose
        int case2= helper (coins, i+1, amount , coinsUsed );

        if(case1== -1) return case2;
        if(case2== -1) return case1;

        return -1;
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = amount;
        int n = coins.length ;
        int [] [] dp = new int [n+1] [m+1];

        for (int j =1 ; j<= amount ; j++){
            dp[0][j] = amount +1; // connot be greater than amount
        }

        for (int i =1; i <=n ; i++){
            for (int j=1; j<=m; j++){
                //for amt > zero case
                if( j < coins[i-1]){
                     dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if (dp[n][m] >= amount+1 ) return -1;
        return dp[n][m];
     }
}

// Space O(m)
// Moving to 1D array from matrix is the optimaization of space -- just to reduce space as we are using the previous row only
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = amount;
        int n = coins.length ;
        int [] dp = new int [m+1];

        for (int j =1 ; j<= amount ; j++){
            dp[j] = amount +1; // connot be greater than amount
        }

        for (int i =1; i <=n ; i++){
            for (int j=1; j<=m; j++){
                //for amt > zero case
                if( j < coins[i-1]){
                     dp[j] = dp[j];
                }else {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i-1]]);
                }
            }
        }
        if (dp[m] >= amount+1 ) return -1;
        return dp[m];
     }
}