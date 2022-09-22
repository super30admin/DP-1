// TC - O(length of coins array * amount)
// SC - O(length of coins array * amount)

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] memo = new int[coins.length][amount+1];
        int ans = minCoins(coins,amount,0,memo);
         if(ans==100001) return -1;
        return ans;
    }
    
    public int minCoins(int[]coins,int amt,int currIndex,int[][]memo){
        
        if(amt==0) return 0;
        
        if(currIndex>=coins.length) return 100001;
        
        if(memo[currIndex][amt]!=0) return memo[currIndex][amt];
        
        int Consider = 100001;
        
        if(amt>=coins[currIndex]){
            Consider = 1 + minCoins(coins,amt-coins[currIndex],currIndex,memo);
        }
        int notConsider =  minCoins(coins,amt,currIndex+1,memo);
        
        memo[currIndex][amt] = Math.min(Consider,notConsider);
        
        return memo[currIndex][amt];
    }
}