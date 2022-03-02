//Time complexity: O(amount*length)
//Space complexity: O(amount*length)
class Solution {
    private int[][] dp;
    public int coinChange(int[] coins, int amount) {
        
        dp = new int[coins.length][amount+1];
        int count = coinsCount(coins, 0, amount);
        return count==Integer.MAX_VALUE?-1:count;
        
    }
    
    public int coinsCount(int[] coins, int index, int amount){
        
        //if amount becomes zero we dont have to consider the coin and can break the chain
        if(amount ==0)
            return 0;
        
        // amount becomes negative or if the coins are over then break the chain
        if(amount<0 || index==coins.length)
            return Integer.MAX_VALUE;
        
        //checking the previously computed value
        if(dp[index][amount]>0)
            return dp[index][amount];
        
        if(dp[index][amount]==0){
            //if coin is not considered amount will remain same, we will move to the next coin
            int coinNotCon = coinsCount(coins, index+1, amount);

            //if coin is considered amount will be reduced and the index will remain same
            int coinCon = coinsCount(coins, index, amount-coins[index]);

            //if valid amount then coincount to be increased by 1
            if(coinCon!=Integer.MAX_VALUE)
                coinCon+=1;
            
            dp[index][amount] = Math.min(coinNotCon, coinCon);
        
        }
        
        return dp[index][amount];
        
        
    }

}
