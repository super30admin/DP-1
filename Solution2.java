// Leetcode Problem : https://leetcode.com/problems/house-robber/description/
// Time Complexity : O(n) where n is the total number of houses
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 For the base condition, I return nums[0] nums array contains only one element. I create a dp array of size nums.length and
 use a prev variable which is initially set to 0. I assign current as the first element and result as 0. Now I iterate from
 the second element of nums array and calculate result as maximum of (prev+nums[i]) and current element. Then I set prev to 
 current and current to result. At the end of all iterations, I return result.
 */

 class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        int dp[] = new int[nums.length];
        int prev = 0;
        int current=nums[0];
        int result=0;
        for(int i=1;i<dp.length;i++)
        {
            result = Math.max(nums[i]+prev,current);
            prev=current;
            current=result;
        }
        return result;

    }
}
