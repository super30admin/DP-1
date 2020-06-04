class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length==0) return 0;
        return minCoin(coins,amount,0,0);
    }
    
    public int minCoin(int[] coins,int amount, int index,int ans){
        if(amount==0) return ans;
        if(amount < 0 || index==coins.length) return -1;
        int case1=minCoin(coins,amount-coins[index],index,ans+1);
        int case2=minCoin(coins,amount,index+1,ans);
        if(case1==-1) return case2;
        if(case2==-1) return case1;
        return Math.min(case1,case2);
    }
}