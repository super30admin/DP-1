class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0) return 0;
        return ans(coins, amount, 0,0);
        
    }
    private int ans(int coins[], int amount, int index, int nofcoins)
    {
        if(amount ==0) return nofcoins;
        if(amount<0|| index==coins.length) return -1;
        int a=ans(coins, amount-coins[index], index, nofcoins+1);
        int b=ans(coins,amount,index+1,nofcoins);
        if(a==-1) return b;
        if(b==-1) return a;
        return Math.min(a,b);
    }
}
