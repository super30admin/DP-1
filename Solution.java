//Time Complexity:O((coins.length) * (amount))
//Space Complexity:O((coins.length) * (amount))
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;

        int[][] matrixdp = new int[coins.length + 1][amount+1];

        for( int i = 1; i< matrixdp[0].length; i++){
            matrixdp[0][i] = 99999;
        }

        for(int i = 1; i< matrixdp.length; i++){
            for(int j = 1; j< matrixdp[0].length; j++){
                if(j < coins[i - 1]){
                    matrixdp[i][j] = matrixdp[i-1][j];
                } else {
                    matrixdp[i][j] = Math.min(matrixdp[i-1][j], 1+ matrixdp[i][j - coins[i - 1]]);
                }
            }
        }

        if(matrixdp[matrixdp.length - 1][matrixdp[0].length - 1] > amount){
            return -1;
        }

        return matrixdp[matrixdp.length - 1][matrixdp[0].length - 1];
    }
}
