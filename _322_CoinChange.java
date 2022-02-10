class Solution {
  // space complexity - o(n*2)
      	//time - o(n*2)
        //Ran on leeetcode successfully : Yes
        // Problem faced  : No
      	//Approach ://top to down approach, using recursion and memoization
	  int[][] dp;
    public int coinChangeTopDown(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        if(amount == 0) return 0;
        if(coins == null || coins.length ==0) return -1;
        int res =  coinChange(coins, amount, 0);
        return  (res == Integer.MAX_VALUE-1) ? -1 : res;
    }

    public int coinChange(int[] coins, int amount, int index) {

        if(amount == 0) return 0;
        if(amount < 0 ) return Integer.MAX_VALUE-1;
        if(index >= coins.length) return Integer.MAX_VALUE-1;
        if(dp[index][amount] != 0) return dp[index][amount];

        int excludeCurrCoin =  coinChange(coins, amount, index+1);
        int includeCurrCoin =  1 + coinChange(coins, amount-coins[index], index);

        dp[index][amount] = Math.min(excludeCurrCoin,includeCurrCoin);
        return  dp[index][amount];
    }

    // space complexity - o(n*2)
        	//time - o(n*2)
          //Ran on leeetcode successfully : Yes
          // Problem faced  : No
    // bottom up approach using iteration and memoization
      public int coinChange(int[] coins, int amount) {

        if(amount == 0) return 0;
        if(coins == null || coins.length == 0) return -1;

        int[][] matrix = new int[coins.length+1] [amount+1];

        for(int i=0; i<matrix.length; i++){
          for(int j=0; j<matrix[0].length; j++){

            if(i == 0 || j == 0){
              matrix[i][j] = Integer.MAX_VALUE-1;
            }
            else if(j < coins[i-1]){
                matrix[i][j] = matrix[i-1][j];
              }
            else if(j == coins[i-1]){
                    matrix[i][j] = 1;
            }
            else{
                int excludeCurrentCoin = matrix[i-1][j];
                int includeCurrentCoin = 1 + matrix[i][j - coins[i-1]];
                matrix[i][j] = Math.min(includeCurrentCoin,excludeCurrentCoin);
          }
        }
      }

        return matrix[matrix.length-1][matrix[0].length-1] == Integer.MAX_VALUE-1 ? -1 : matrix[matrix.length-1][matrix[0].length-1];
      }
}
