// Time Complexity : O(coins.length x amount+1)
// Space Complexity :  O(coins.length x amount+1)
// Did this code successfully run on Leetcode : yes 

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int [][] matrix = new int[coins.length+1][amount+1];
        
        for(int i=1; i< amount+1; i++) {
            matrix[0][i] = amount+1;            
        }
        
        
        for(int i=1; i<matrix.length; i++ ){
            
            for(int j=1; j<matrix[0].length; j++){
                
                if(j<coins[i-1]){
                    matrix[i][j] = matrix[i-1][j];
                }                
                else{
                    matrix[i][j] = Math.min(matrix[i-1][j], 1+ matrix[i][j - coins[i-1]]);
                }
    
            }                                    
            
        }
        
        int result = matrix[coins.length][amount];
        
        if(result > amount)
            return -1;
        else
            return result;
        
    }

}