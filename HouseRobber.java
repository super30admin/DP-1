class Solution {
    public int rob(int[] nums) {
        
        //Check if the nums array is empty, if so return 0
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        //#rows = length of nums array
        //#columns = 2 - column 1 represents choosing that house to rob
        //               column 2 represents what if you dont chose that house
        int n = nums.length;
        int m = 2;
        
        // creating an array of size n*m
        int[][] dp = new int[n][m];
        
        //Intializing the edge cases
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        
        //Loop through the dp array
        //if the column == 0 the add the nums that matches the row and 
        // the previous rows column 0
        //else get the max value from previous row columns
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 2; j++){
                if(j == 0){
                    dp[i][j] = nums[i] + dp[i-1][1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][0], dp[i-1][1]);
                }
            }
        }
        
        // return max value of last row elements
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}