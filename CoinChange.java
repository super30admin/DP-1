

import java.util.Arrays;
//Asymptotic complexity in terms of n = size of the input array 'coins' and the variable 'amount'
// Time Complexity : O(n * amount)
// Space Complexity : O(n+amount)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No


public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[]dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int c:coins){
            for(int i=c;i<=amount;i++){
                dp[i]=Math.min(dp[i],dp[i-c]+1);
            }
        }
        return dp[amount]<=amount ? dp[amount] : -1;
    }
    public static void main(String[] args){
        int[] coins = {1,2,5};
        int amount = 11;

        int result = coinChange(coins, amount);
        System.out.println(result);
    }
}
