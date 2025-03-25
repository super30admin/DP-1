 
//TC and SC: O(m*n)

//Approach 2b: DP solution with 1D array
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //Decision Parameters comes from exhaustive approach
        // Each cell in tabulation is an exhaustive tree
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n+1];
        // dp[0][0] = 0; //Zeroth row filing

        for(int j=1; j<=n; j++){
            dp[j] = 99999;  //First row filling to infinity why not Integer.MAX_VALUE()
        }

        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1]){ //amount < denomination of coin
                    //no choose case
                    dp[j] = dp[j];
                }else{
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i-1]]);
                }
            }
        }
        if(dp[n]==99999) return - 1;
        return dp[n];
    }
} 

// Approach 1a: Exhaustion(Brute force)/Trying all the possible combinations
//Time limit exceeded //Goto Approach2
//TC: 2 power of (m+n) // exponentially growing
//SC : (m+n)
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int res = helper(coins, 0, amount, 0);
//         if(res == Integer.MAX_VALUE) return -1;
//         return res;
//     }

//     private int helper(int[] coins, int i, int amount, int coinsUsed){ //i = index of coins array - which coin we are on 
//         //base case
//         if(amount < 0 || i == coins.length) return Integer.MAX_VALUE; // when amount becomes -ve and traversed until end by not choosing and exhausting coins, in that case i will be acrossingt the last index of array
//         if(amount == 0) return coinsUsed;
//         //don't choose
//         int case0 = helper(coins, i+1, amount, coinsUsed);
//         //choose
//         int case1 = helper(coins, i, amount-coins[i], coinsUsed+1);

//         return Math.min(case0, case1);
//     }
// }  

// // Approach 1a: Void based recursion for the same approach above
// class Solution {
//     int count;
//     public int coinChange(int[] coins, int amount) {
//         this.count = Integer.MAX_VALUE;
//         helper(coins, 0, amount, 0);
//         if(count == Integer.MAX_VALUE) return -1;
//         return count;
//     }

//     private void helper(int[] coins, int i, int amount, int coinsUsed){ //i = index of coins array - which coin we are on 
//         //base case
//         if(amount < 0 || i == coins.length) {
//             return; 
//         } // when amount becomes -ve and traversed until end by not choosing and exhausting coins, in that case i will be acrossingt the last index of array
//         if(amount == 0){
//            count = Math.min(count, coinsUsed);
//            return;
//         } 
//         //don't choose
//         helper(coins, i+1, amount, coinsUsed);
//         //choose
//         helper(coins, i, amount-coins[i], coinsUsed+1);

//     }
// }  
// Approach 2a : DP Solution with 2D matrix
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         //Decision Parameters comes from exhaustive approach
//         // Each cell in tabulation is an exhaustive tree
//         int m = coins.length;
//         int n = amount;

//         int[][] dp = new int[m+1][n+1];
//         // dp[0][0] = 0; //Zeroth row filing

//         for(int j=1; j<=n; j++){
//             dp[0][j] = 99999;  //First row filling to infinity why not Integer.MAX_VALUE()
//         }

//         for(int i=1; i<=m; i++){
//             for(int j=0; j<=n; j++){
//                 if(j < coins[i-1]){ //amount < denomination of coin
//                     //no choose case
//                     dp[i][j] = dp[i-1][j];
//                 }else{
//                     dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
//                 }
//             }
//         }
//         if(dp[m][n]==99999) return - 1;
//         return dp[m][n];
//     }
// } 

