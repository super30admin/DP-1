public class CoinChange {
    //TC is O(mn) where m is distinct conis available and n is the max amount
    // SC is O(mn) as new matrix is created
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] matrix = new int[m+1][n+1];
        for(int k=1; k<matrix[0].length;k++){
            matrix[0][k] = 99999;
        }
        for(int i=1; i<matrix.length;i++){
            for(int j=1; j<matrix[0].length;j++){
                if(j<coins[i-1]){
                    matrix[i][j] = matrix[i-1][j];
                }else{
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-coins[i-1]]+1);
                }
                
            }
        }
        if(matrix[m][n] >= 99999) return -1;
        return matrix[m][n];
    }
    
    
}