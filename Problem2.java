//Problem: 198. House Robber
/** 3 Pointer Approcach: 
 * Used Dp and plotted a 2D array for chossing the house or not chossing the house.
 * The choice of using DP was choosesn after evaluating the BruteForce solution.
 * The brute force was resulting in multiple combinations and many of them are repetativ sub problem steps. 
 * The sub problems were repetitive fot brute force.
 * 
 * 
 * Rob the house OR Not Rob the house
Example => 
input = [1,2,3,1]
Select/NotSelect
0, 1, 
1, 2, 
2, 4, 
4, 3, 
 */ 
//
//time Complexity :
// O(2^N) 

// Space Complexity :
// O(N)

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO.

class Problem2 {
    public int rob(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        int[][] dp = new int[nums.length][2];
        
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        for(int house=1; house<nums.length; house++){
            
            // not rob
            
            dp[house][0]= Math.max(dp[house-1][0], dp[house-1][1]);
            
            //rob
             dp[house][1]= nums[house] + dp[house-1][0];
        }      
        
//         for(int row = 0; row < nums.length; row++){
          
//             for(int col = 0; col < 2; col++){
             
//              System.out.print(dp[row][col] + ", ");
             
//             }
//              System.out.println("");
//         }
          
        
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}