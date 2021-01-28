//Time complexity: O(mn)
//Space complexity: O(mn)
// m = length of coins array, n = amount value

class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length + 1; // +1 for 0 values
        int n = amount + 1;
        
        //create a 2D dp array for maintaining coins required at each point
        int[][] dp = new int[m][n];
        
        //fill out 1st row with max possible value i.e. amount + 1
        for(int i = 0; i < n; i++){
            dp[0][i] = amount + 1;
        }
        
        //fill out 1st column with default value of 0
        for(int i = 0; i < m; i++){
            dp[i][0] = 0;
        }
        
        //update the dp array
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(j < coins[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else{
                    int choose = 1 + dp[i][j - coins[i - 1]];
                    int donchoose = dp[i - 1][j];
                    dp[i][j] = Math.min(choose, donchoose);
                }
            }
        }
        
        return dp[m-1][n-1] > amount ? -1 : dp[m-1][n-1];
    }
}