
// Exhaustive approach - Runtime exceeded for some cases
public class CoinChangeBrute {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return 0;
        
        return helper(coins,amount,0,0);
    }
    
    private int helper(int[] coins, int amount, int i, int min){
        //base
        if(amount < 0 || i == coins.length) return -1;
        if(amount==0) return min;
        
        //logic
        //case 1 - choose
        int case1 = helper(coins, amount-coins[i],i,min+1);
        
        //case 0 - Not choose
        int case0 = helper(coins,amount,i+1,min);
        if(case1 == -1) return case0;
        if(case0 == -1) return case1;
        return Math.min(case1,case0);
    }
}

// Time Complexity - O(2 power n)
// Space Complexity - O(2 power n)

// 2D Array - DP Solution
public class CoinChangeDP {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0) return 0;
        
        int m = coins.length; // number of rows
        int n = amount; // number of columns
        int[][] dp = new int[m+1][n+1];
        // Create one dummy row
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=amount+1; // Maximum value in dummy row
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                // Not choose case - Till the amount is less than the denomination
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{ // choose case
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        
        int result = dp[m][n];
        if(result>amount) return -1;
        else return result;
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)
