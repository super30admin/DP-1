//This can be solved using greedy apporach. 
//The approach which we are going to follow is the one which takes performs the choose/not choose strategy. 
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         //Backtracking
        
//         return helper(coins, 0, amount, 0);
//     }
    
//     private int helper(int[] coins, int index, int amount, int coins_used)
//     {
//         //base condition 
//         //when the amount becomes zero or when the array length reaches end
//         if(amount < 0 || index == coins.length)
//             return -1;
//         if(amount == 0)
//             return coins_used;
//         //logic
//         //case 1:
//         int case1 = helper(coins, index + 1, amount, coins_used);
//         //case 2:
//         int case2 = helper(coins, index, amount - coins[index], coins_used + 1);
        
//         if(case1 == -1)
//             return case2;
//         if(case2 == -1)
//             return case1; 

//     return Math.min(case1, case2);
//     }
// }


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 ||coins == null) return -1;
        
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int j = 1; j < n + 1; j ++){
            dp[0][j] = amount + 1;
        }
        for(int i = 1 ; i < m + 1; i++){
            for(int j = 1; j < n+1; j++){
                if( j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        if(dp[m][n] == amount + 1)
            return -1;
        
        
        return dp[m][n];
    }
    
}