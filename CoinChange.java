class CoinChange {
    public int coinChange(int[] coins, int amount) {
        return helper(coins,0,amount,0);
    }
    
    private static int helper(int[] coins,int coinIndex,int remainingAmount,int noOfCoin)
    {
        // base condition
        if(remainingAmount<0 || coinIndex> coins.length-1) return -1;
        if(remainingAmount==0) return noOfCoin;
        //case 1
        int coinChoosen = helper(coins, coinIndex,remainingAmount - coins[coinIndex],noOfCoin+1 );
        //case 2
        int coinNotChoosen = helper(coins, coinIndex+1, remainingAmount, noOfCoin);
        //final result
        if(coinChoosen==-1) return coinNotChoosen;
        if(coinNotChoosen==-1) return coinChoosen;
        else return Math.min(coinChoosen,coinNotChoosen);
    }
}