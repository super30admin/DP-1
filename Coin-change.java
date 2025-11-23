//Normal recursion is exhaustive & gives exponential time complexity
//we have infinite supply of coins
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0 || coins == null) return -1;
        return recurse(coins, amount, 0, 0);
    }
    private int recurse(int[] coins, int amount, int index, int coinsUsed){
        //base
        if(coins.length==index || amount <0) return -1;//index out of bound
        if(amount == 0) return coinsUsed;
        //logic
        //not choose that denomination
        int case0 = recurse(coins, amount, index+1, coinsUsed);
        //choose that denomination
        int case1 = recurse(coins, amount - coins[index], index, coinsUsed+1);
        if(case0 == -1) return case1;
        if(case1 == -1) return case0;

        return Math.min(case0, case1);
    }
    //dp method
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0 || coins == null) return -1;
        int n = coins.length;
        int m = amount;
        int[][] dp = new int[n+1][m+1];
        for(int j=1;j<=m;j++){
            dp[0][j] = amount+1;//setting first dummy row as infinity except first element

        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //denomination > amount
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];//same element as above
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);//case0, case1(1 for choosing that coin + its value is in same row & denamination step back)
                }
            }

        }
        int res = dp[n][m];//return last element which is fewest number of coins that you need to make up that amount
        if(res>=amount+1) return -1;
        return res;
    }
}