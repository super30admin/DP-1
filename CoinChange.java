package S30_Codes.DP_1;

// Time Complexity : O(m*n)  // n = total no of coins // m = required amount
// space Complexity : O(m)


class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int cache[] = new int[amount+1];
        getMinCoins(coins, amount, cache);
        return cache[amount];
    }

    private int getMinCoins(int[] coins, int amt, int[] cache){
        if(amt == 0)
            return 0;

        if(amt < 0)
            return -1;

        if(cache[amt] == 0){
            int minCoin = Integer.MAX_VALUE;
            for(int i=0; i<coins.length; i++){
                int newAmt = amt-coins[i];
                int currentCoin = getMinCoins(coins, newAmt, cache);

                if(currentCoin >= 0)
                    minCoin = (currentCoin < minCoin) ? currentCoin : minCoin;
            }

            if(minCoin == Integer.MAX_VALUE)
                cache[amt] = -1;
            else
                cache[amt] = minCoin+1;
        }
        return cache[amt];
    }
}