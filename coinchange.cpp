
// Time Complexity : O( coins.size() * amount )
// Space Complexity : O( coins.size() * amount ) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None



class Solution {
public:

    
    int coinChange(vector<int>& coins, int amount) {
        int maxvalue = 100001;
        int rows = coins.size() + 1;
        int cols = amount + 1;
        int matrix[rows][cols];
        memset( matrix, 0, rows*cols*sizeof(int) );
        for( int j=1; j<cols; j++ ){
                matrix[0][j] = 100001;
        } 
        for( int i = 1; i< rows; i++ ){
             for( int j=1; j<cols; j++ ){
                if( coins[i-1] > j ){
                    matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = min( matrix[i-1][j], 1+matrix[i][j-coins[i-1]] );
                }
             }
        }
        if( matrix[rows-1][cols-1] == maxvalue ) {
            return -1;
        }
        return matrix[rows-1][cols-1];
        
    }
};
