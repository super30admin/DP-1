import java.util.Arrays;

public class CoinChange {
    //https://leetcode.com/problems/coin-change/
    public static void main(String[] args) {
    int[] coins ={1,2,5};
    int amount =11;
        System.out.println(coinChange(coins,amount));
    }
//Below is brute force recursive approach
/*
    public static int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length ==0) return -1;
        return helper(coins,amount, 0,0);
    }
    private static int helper(int[] coins, int amount, int index, int coinsUsed){

        if(index==coins.length||amount<0) return -1;
        if(amount==0) return coinsUsed;
        int case1 =helper(coins,amount,index+1, coinsUsed);
        int case2 =helper(coins, amount-coins[index],index, coinsUsed+1);
        if(case1==-1) return case2;
        if(case2==-1) return case1;
        return Math.min(case1,case2);
    }*/

    // Dynamic Programming approach
    public static int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length ==0) return -1;
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        //System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i <amount+1 ; i++) {
            dp[0][i]= amount+1;
        }
//        System.out.println(Arrays.deepToString(dp));


        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <amount+1 ; j++) {
        if(j<coins[i-1]) dp[i][j]= dp[i-1][j];
        else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]);
            }
        }
        if(dp[n][amount] == amount + 1)return -1;
return dp[n][amount];
    }


}
