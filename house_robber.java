// Time Complexity : O(n) - length of array
// Space Complexity : O(2n) - Dp matrix
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int rows = nums.length;
        int columns = 2; //C or DC
        
        int dp[][] = new int[rows][columns];
        
        dp[0][0]=nums[0]; //C
        dp[0][1]= 0; //DC
        
        for(int i=1;i<rows;i++){
            //Choose - 0, Don't Choose - 1
            for(int j=0;j<columns;j++){
                if(j==0){//Choose part
                    dp[i][j]=nums[i]+dp[i-1][1];// i value in coins indice + dont' chose from the top row
                }
                else{//Don't choose part
                    dp[i][j]= Math.max(dp[i-1][0],dp[i-1][1]); // Maximum of choose and don't choose for above row
                }
            }
        }
        
        return Math.max(dp[rows-1][0],dp[rows-1][1]);// Maximum of 0 indice and 1 indice of last row
    }
}
