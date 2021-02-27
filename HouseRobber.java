// Time Complexity : O(n)
// Space Complexity : O(2n)= O(n) for 2-d array approach; O(1) for temp approach
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//2D array Approach
class Solution {
    public int rob(int[] nums) {
        if(nums ==null || nums.length == 0)
            return 0;
        int n = nums.length; //length of the array  
        int m = 2; //choose and dont choose
        
        int[][] dp = new int[n][m];
        
        dp[0][0] = nums[0];
        dp[0][1] = 0; //starting
        
        for(int i = 1; i< n; i++){ //c ->0; DC -> 1
            for(int j = 0; j < m; j++){
                if(j==0){ //Choose option
                    dp[i][j] = nums[i] + dp[i-1][1];
                }
                else
                { dp[i][j] = Math.max(dp[i-1][0], dp[i-1][1]);
                    
                }
            }
            
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}

//Temp approach
/*
class Solution {
    public int rob(int[] nums) {
        if(nums ==null || nums.length == 0)
            return 0;
        int c = 0, dc = 0;
        
        for(int i: nums){
            int temp = dc;
            dc = Math.max(c,dc);
            c = i + temp;
            
        }
        
        return Math.max(c,dc);
    }
}
*/