
/**
 * Brute Force - Will cause Tume Limit Exceeded
 * class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = helper(coins, 0, amount, 0);
        if(res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
    private int helper(int[] coins, int i, int amount, int coinsUsed){
        //Base Case
        if(amount < 0 || i==coins.length)
            return Integer.MAX_VALUE;
        if(amount == 0)
            return coinsUsed;
        //NoChoose
       int noChoose = helper(coins, i+1, amount, coinsUsed);
        //Choose
       int choose = helper(coins, i, amount - coins[i], coinsUsed+1);
       return Math.min(noChoose, choose);
    }
}
 */
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][] tab = new int[m+1][n+1];
        
        for(int i=1; i<=n; i++){
            tab[0][i] = 99999;
        }
        for(int i=1; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(j < coins[i-1])
                    tab[i][j] = tab[i-1][j];
                else{
                    tab[i][j] = Math.min(tab[i-1][j], tab[i][j-coins[i-1]]+1);
                }
            }
        }
        if(tab[m][n] == 99999)
            return -1;
        return tab[m][n];
    }
}


