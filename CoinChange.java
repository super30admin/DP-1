
public class CoinChange {
	//Recursive approach
    /*public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null) retunr -1;
        return helper();
    }
    
    private int helper(int[] coins, int amount, int index, int min){
        //base
        if(amount == 0) return min;
        if(amount < 0 || index == coins.length) return -1;
        //logic
        //choose the coin
        int case1 = helper(coins, amount - coins[index], index, min + 1);
        //dont choose the coin
        int case2 = helper(coins, amount, index + 1, min);
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return Math.min(case1, case2);
    }
    */
    
    public static int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || coins == null) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = 999999;
        }
        for(int i = 1;i<dp.length; i++){
            for(int j = 1; j<dp[0].length;j++){
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else
                {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[dp.length - 1][dp[0].length - 1];
        if(result >= 999999) return -1;
        return result;
    }
    
    public static void main(String[] args) {
    	int[] coins  = {1,3,5};
    	int amount = 11;
    	System.out.println(CoinChange.coinChange(coins, amount));
	}
}
