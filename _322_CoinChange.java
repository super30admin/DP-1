class Solution {
      public int coinChange(int[] coins, int amount) {

        int[][] matrix = new int[coins.length+1] [amount+1];

        for(int i=0; i<matrix.length; i++){
          for(int j=0; j<matrix[0].length; j++){

            if(i==0 || j==0){
              matrix[i][j] = 0;
            }
            else{
              if(j < coins[i-1]){
                matrix[i][j] = matrix[i-1][j];
              }
              else{
                int includeCurrentCoin = 1 + matrix[i][j - coins[i-1]];//
                int excludeCurrentCoin = matrix[i-1][j];
                matrix[i][j] = Math.min(includeCurrentCoin,excludeCurrentCoin);
              }

            }

          }
        }

        return matrix[matrix.length-1][matrix[0].length-1];
}
}
