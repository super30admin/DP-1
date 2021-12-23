class Solution{
    public int coinChange(int[] coins, int amount){
        if(coins.length == 0 || coins == null) return 0; // if there are no coins, we return 0;
        int [][] dp = new int [coins.length + 1][amount + 1]; // we are declaring a 2d array with name as dp, which can take the values of coins and amount. Since we also considering 0, we take +1 for both.
        for(int j = 1; j < amount + 1; j++){ // we go through all the elements present in amount starting from 1.
            dp[0][j] = amount +1; // we take the index 0 of coins where the value of it is 0, and set all the amounts of coin 0 to infinity.
        }
        for(int i = 1; i < coins.length + 1; i++){ //we go through each and every element present in coins one by one.
            for(int j = 1; j < amount.length + 1; j++){ //we go through each and every element present in amounts.
                if(j < coins[i -1]){ // if the amount at j is less than the value of coins at i -1
                    dp[i][j] = dp[i-1][j]; // we give the value of the coin present at the previous index to the present index.
                }
                else{ // if j is greater than or equal to coins[i-1].
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]) //we compare the value of coins at the previous index i-1 and 1+ value of at the current index but j- of the i's previous index.
                }
            }
        }
        if(dp[coins.length][amount] > amount){ // if the value of coins at the last index is greater than the amount
            return -1; // we return -1
        }
        return dp[coins.length][amount]; // else return the value
    }
}
//// TC and SC - O(coins length)(amount)