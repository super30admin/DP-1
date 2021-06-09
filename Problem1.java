// 322.
// DP Approach

class Solution {

    public int coinChange(int[] coins, int amount) {

        if(coins.length == 0 || amount < 0){
            return -1;
        }

        int[][] minCoins = new int[coins.length+1][amount+1];

        minCoins[0][0] = 0;

        for (int i = 1; i<amount+1;i++){
            minCoins[0][i] = amount+1;
        }
        for (int i = 0; i<coins.length+1;i++){
            minCoins[i][0] = 0;
        }

        for (int i = 1; i<coins.length+1;i++){
            for (int j = 0; j<amount+1;j++){
                if (coins[i-1] > j){
                    minCoins[i][j] = minCoins[i - 1][j];
                }
                else{
                    minCoins[i][j] = Math.min(1+ minCoins[i][j - coins[i-1]], minCoins[i - 1][j]) ;
                }
            }
        }

        if (minCoins[minCoins.length-1][minCoins[0].length-1] >= amount+1 ){
            return -1;
        }
        return minCoins[minCoins.length-1][minCoins[0].length-1];

    }

} 