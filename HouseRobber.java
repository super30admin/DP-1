// Time Complexity :o(n) 
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//The approach I have used here is that we are maintaining the current maximum value that the robber can rob.
//We compare that with the previous from the dp array and the sum of the current element with two step behind from the dp array
//In the end we get the answer at the last index of the dp array

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        
        //if null array
        if(n==0)
        {
            return 0;
        }
        //if just one element in the array
        if(n==1)
        {
            return nums[0];
        }
        //if two elements in the array , return the max of both elements
        if(n==2)
        {
            return Math.max(nums[1],nums[0]);
        }
        	//always put the first element of the array to dp
            dp[0] = nums[0];
            //max of the first element and second element from nums to dp
            dp[1] = Math.max(nums[0],nums[1]);
            
            for(int i=2;i<nums.length;i++)
            {
            	//compare one step back element of dp array and sum of current element and two step back from dp
            	//Store this in the current index of the dp array
                dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
            }
        //last index has the maximum robbed value
        return dp[n-1];
    }
}