

// Time Complexity : O(nums.size() * total sum of nums ) , that is the matrix i created
// Space Complexity : O( nums.size() * total sum of nums ) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
public:
    
    int rob(vector<int>& nums) {
      int sum = 0;
      for( int i = 0; i<nums.size(); i++){
          sum += nums[i];
      }
      int cols = sum +1;
      int rows = nums.size() + 1;
      int matrix[rows][cols];
      memset( matrix, 0, rows*cols*sizeof(int));
      for( int i=0; i<rows; i++){
          matrix[i][0] = 1;
      }
      
      // make single house amount to be true , rest are already false coz of memset
      matrix[1][nums[0]] = 1;
        
      for( int i=2; i<rows; i++){
          for (int j=1; j<cols; j++) {
              if( nums[i-1] > j){
                  matrix[i][j] = matrix[i-1][j];
              } else {
                  matrix[i][j] = ( matrix[i-1][j] || matrix[i-2][j-nums[i-1]] );
              }
          }
      }
      int answer;
      for( int j=0; j<cols; j++){
         if( matrix[rows-1][j] == 1 ) {
             answer = j;
         }
      }
      return answer;
        
    }
};
