class CoinChange {
    //time: exponential-> O(nk) where n=Num of coins, k=amount;
    //space: O(nk)
	//Did it run successfully on leetcode: yes
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        //intializing first row with value greater than amount
         for(int j=0; j<dp[0].length; j++){
            dp[0][j] = amount+1;    
         }
        //looping through dp matrix
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                //if current coin is greater than the current amount
                if(coins[i-1]>j){
                    //we don't pic any coin and take the old value
                    dp[i][j] = dp[i-1][j];
                }
                 //if current coin is less than the current amount
                else{
                    //pick min among, when we select a coin and when we don't select a coin
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);                  
                }
            }
        }
        //if amount can't be formed
        if(dp[coins.length][amount]==amount+1) return -1;
        
        // if amount can be formed
        return dp[coins.length][amount];
    }
}