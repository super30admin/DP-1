//TC: O(n)
//SC: O(1)

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins.length==0 || coins==null){
            return 0;
        }
        
        //as we need 0th index for oth the rows and the columns;
        int dp[][]= new int[coins.length+1][amount+1];
        
        
        //setting all the values to amount+1; in 0th row and 1st column;
        for(int j=1;j<amount+1;j++){
            dp[0][j]=amount+1;
        }
        
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(j<coins[i-1])      { //condition check for the index of amt with the current coin of the array we are given; so i-1;
                    dp[i][j]=dp[i-1][j];
                }  
                    //i-1 as coins from the problem array need to be considered;
                
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        if(dp[coins.length][amount]>amount){
            return -1;
        }
        return dp[coins.length][amount];
    }
}
