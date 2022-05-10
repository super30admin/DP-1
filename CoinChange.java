//Time Complexity: O(mn)
//Space Complexity:O(mn)


public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        //null case
        if(coins == null || coins.length ==0){
            return 0;
        }

        int[][] dp = new int[coins.length+1][amount+1];

        //Fill the top row
        for(int j=1; j< dp[0].length;j++){
            dp[0][j] = 9999;
        }

        for(int i=1;i<dp.length;i++){

            for(int j=1;j<dp[0].length;j++){

                //case 0 only

                if(j < coins[i-1]){
                    dp[i][j] =  dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
            }
        }

        int result = dp[dp.length-1][dp[0].length-1];
        if(result>=9999){
            return -1;
        }

        return result;
    }
}
