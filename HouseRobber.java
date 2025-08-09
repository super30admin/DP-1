import java.util.*;

// 1. Recursive Approach

// Time Complexity : O(2^n) - Each house decision branches into two paths: rob or skip
// Space Complexity : O(n) - Recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// - At each index, we choose to either rob this house (and skip the next) or skip this house
// - Base case: when index goes out of bounds, return total money robbed
public class HouseRobber 
{
    public int rob(int[] nums)
    {
        // Start recursion from index 0 with total = 0
        return helper(nums,0,0);
    }
    public int helper(int[] nums,int i,int totalRobbings)
    {
        // Base case: no houses left to rob
        if(i>=nums.length)
        {
            return totalRobbings;
        }
        // Case 0: skip current house
        int case0=helper(nums,i+1,totalRobbings);
        // Case 1: rob current house, skip next
        int case1=helper(nums,i+2,totalRobbings+nums[i]);
        // Return max profit from the two choices
        return Math.max(case0,case1);
    }
}



// 2. DP Approach - 1D Array
// Time Complexity : O(n)
// Space Complexity : O(n) - dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// - dp[i] stores the max amount that can be robbed from house 0 to i
// - Recurrence: dp[i] = max(dp[i-1], dp[i-2] + nums[i])
class HouseRobber1D
{
    public int rob(int[] nums)
    {
        int n=nums.length;
        if(n==1) return nums[0]; // Edge case: only one house
        
        int[] dp=new int[n];
        
        dp[0]=nums[0]; // Base case: rob first house
        dp[1]=Math.max(nums[0],nums[1]); // Rob the max of first two houses
        
        // Fill dp table
        for(int i=2;i<n;i++)
        {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        // Answer is the last entry
        return dp[n-1];
    }
}


// 3. More Optimized Variable Approach

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// - Instead of storing all states, we only keep track of previous two
// - curr = max till current house, prev = max till house before previous
class HouseRobberVar
{
    public int rob(int[] nums)
    {
        int n=nums.length;
        if(n==1) return nums[0]; // Edge case
        
        int prev=nums[0]; // dp[i-2]
        int curr=Math.max(nums[0],nums[1]); // dp[i-1]
        
        for(int i=2;i<n;i++)
        {
            int temp=curr; // Store dp[i-1] temporarily
            curr=Math.max(prev+nums[i],curr); // Choose rob or skip
            prev=temp; // Move window forward
        }
        return curr;
    }
}
