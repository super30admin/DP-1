public class CoinChange_LC_322 {

//Exhaustive solution gives TLE: O(2 ^ amount + length of coins array)

    public int coinChangeTLE(int[] coins, int amount) {
        int result = helper(coins, 0 ,amount);
        if(result >= Integer.MAX_VALUE-10 ) return -1; // we do this for non valid path which will result Integer max number in that case we can conclude there was not coin found to match the maount hence return -1
        return result;

    }
    private int helper(int coins[], int idx, int amount) {

        //base case amount == 0 can also be one of the base case
        if(amount == 0) return 0;

        if(amount < 0 || idx == coins.length) return Integer.MAX_VALUE-10; //since this is not valid path, by taking -1 or 0 will not yield correct result hence we return max because we alwasy take min value of choose and not choose scenario, if we do not take max, our ans will pic incoorect min, and -10 i just to avoid integer overflow becuase we are doing 1 + at every choose scenario

        //logic
        //choose
        int case1 = 1+ helper(coins, idx, amount-coins[idx]);
        //not choose
        int case2 = helper(coins, idx+1, amount);
        return Math.min(case1, case2);
    }


//Time complexity = O(m*n)
//space Complexity = O(m*n)

    public int coinChangeDP(int[] coins, int amount) {
        int m = amount;
        int n = coins.length;
        int [][]dp = new int[n+1][m+1]; //+1 for dp
        dp[0][0] = 0;

        //Lets fill top row with infinity
        for(int j = 1; j <=m; j++){
            dp[0][j] = Integer.MAX_VALUE-10; // -10 is to avoid overflow because we are +1 for coin added
        }
        for(int i = 1; i<=n; i++) {
            for (int j = 1; j <= m; j++) {
                //till the time amount < denomination of coins
                if(j < coins[i-1]) //i- 1 because we have extra dummy - understand more why coins[i-1]
                {
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+ dp[i][j- coins[i-1]]);
                }
            }
        }
        if(dp[n][m] >=Integer.MAX_VALUE-10) return -1; // no coins found to match the amount
        return dp[n][m];
    }
}