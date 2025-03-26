//Time Complexity: O(n) where n is the number of houses
//Space Complexity: O(1)

/**
 * Uses dynamic programming to find the maximum amount that can be robbed without robbing adjacent houses.  
 * Maintains two variables (`twoBack` and `oneBack`) to track the max profit up to the previous two houses, reducing space complexity to O(1).  
 * Iterates through the houses, updating the max profit at each step based on whether to rob the current house or not.
 */

// Problem2 (https://leetcode.com/problems/house-robber/)
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0]; 

        int twoBack = nums[0];
        int oneBack = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length ; i++) {
            int temp = Math.max(oneBack, twoBack+nums[i]);
            twoBack = oneBack;
            oneBack = temp; 
        }

        return oneBack;
        
    }
}
    
