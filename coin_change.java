//time complexity: o(mn)
//space complexity: o(n)

class Solution{
    public int coinChange(int[] coins, int amount){
        if(coins == null || coins.length == 0) return -1;
        //row of the DP matrix
        int m = coins.length;
        //column
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        for(int j =1; j<n+1; j++){
            dp[0][j] =   amount+1;
        }


        for(int i =1; i<m+1; i++){
            for(int j =1; j<n+1; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j] ;
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        if(dp[m][n] == amount + 1){
            return -1;
        }

        return dp[m][n];
    }
}
































// //time limit exceeded for the solution
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         if(coins == null || coins.length == 0) return -1;

//         if(amount == 0) return 0;
//         return helper(coins, amount, 0, 0) ;
//     }
//     private int helper(int[] coins, int amount, int index, int numberofcoinsused){
//         // base
//         if(amount == 0){
//             return numberofcoinsused;
//         }
//         if(index == coins.length || amount< 0){
//             return -1;
//         }


//         //logic
//         // zero case or do not choose case
//         int case1= helper(coins, amount, index+1, numberofcoinsused);
//         // choose case

//         int case2 = helper(coins, amount - coins[index], index, numberofcoinsused+1);

//         if(case1 == -1){
//             return case2;

//         }
//         if(case2 == -1){
//             return case1;
//         }
//         return Math.min(case1, case2);

//     }
// }