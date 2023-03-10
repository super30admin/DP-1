public class CoinChangeDP {
    public int coinChange(int[] coins, int amount) {
        return helper(coins,0, amount, 0);
    }
    private int helper(int[] coins, int idx, int amount, int minCoins){
        if(amount == 0) return minCoins;
        if(amount < 0 || idx== coins.length) return -1;
        int case0 = helper(coins, idx+1, amount, minCoins);
        int case1 = helper(coins, idx, amount-coins[idx], minCoins+1);
        if(case0 == -1) return case1;
        if(case1 == -1) return case0;
        return Math.min(case0, case1);

    }
}
