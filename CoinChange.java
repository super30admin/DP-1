package com.company;

import java.util.Arrays;

public class CoinChange {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            Arrays.fill(dp,amount+1);
            dp[0] = 0;
            for(int coin : coins){
                for(int i=coin; i<= amount; i++){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
            if(dp[amount] > amount)
            {
                return -1;
            }
            else {
                return  dp[amount];
            }
        }
}
