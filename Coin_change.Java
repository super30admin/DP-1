class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) { 
        dp=new int[coins.length][amount+1];
        
        int min_coins=coin_change(amount,0,coins);
        if(min_coins==100000000){
            return -1;
        }else{
            return min_coins;
        }
        
    }


private int coin_change(int amount, int index,int[] coins){
        if(amount==0){
            return 0;
            
        }
        if(amount<0 || index>coins.length-1){
            return 100000000;
        }
        int min_coins;
    if(dp[index][amount]>0){
        return dp[index][amount];
    }
    min_coins=Math.min(1+coin_change(amount-coins[index],index,coins),coin_change(amount,index+1,coins));
    dp[index][amount]=min_coins;    
    return dp[index][amount];   
    }
}


