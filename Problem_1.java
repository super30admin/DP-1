
// Time Complexity : O(n2)
// Space Complexity :O(n2)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// for innital row, add the value amount + 1, then add the same row as above till column is less then the current row. then add the min value of the row above and current row plus 1.
// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if( coins == null || coins.length == 0 ) return 0;
        int [][] result = new int [coins.length+1][amount+1];
        for( int i = 1; i < amount + 1; i++){
            result[0][i] = amount+1;
        }
        for( int i = 1; i < coins.length+1; i ++){
            for( int j = 1; j < amount+1; j++){
                if(j < coins[i-1]){
                    // zero case
                    result[i][j] = result[i-1][j];
                }else{
                    // zero and I case
                    result[i][j] = Math.min(result[i-1][j], 1+result[i][j - coins[i-1]]);
                }
            }
        }
        if(result[coins.length][amount] > amount ) return -1;
        return result[coins.length][amount];
    }
}