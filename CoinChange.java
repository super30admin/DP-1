// Time Complexity : O(N*m) N:Number of coins, m:Amount
// Space Complexity : O(N*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class CoinChange{
    public static void main(String[] args){
        CoinChange s = new CoinChange();
        int[] coins = {1,2,5};
        int result=s.coinChange(coins,11);
        System.out.print("Result: " +result);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] matrix = new int[coins.length+1][amount+1];

        for(int i=1;i<=amount;i++){
            matrix[0][i]=99999;
        }
        for(int i=0;i<=coins.length;i++){
            matrix[i][0]=0;
        }

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j<coins[i-1]){
                    matrix[i][j] = matrix[i-1][j];
                }
                else{
                    matrix[i][j]=Math.min(matrix[i-1][j],1 + matrix[i][j-coins[i-1]]);
                }
            }
        }

        return (matrix[coins.length][amount] >= 99999) ? -1 : matrix[coins.length][amount];

    }
}