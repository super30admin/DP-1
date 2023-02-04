// Time Complexity : O(n), where n is number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use dp here. We use 2 variables to keep track of previous 2 houses. If we dont select the current house value would be equal to
   value of curr for previous house. Else if we select current value would be sum of value of previous to previous house and value 
   of current house. We take max of both cases. Eventually when we iterate through the houses we have max value stored in curr and 
   return it.
*/

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        int n = nums.length;
        //int[] dp = new int[n];

        if(n == 1)
            return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; ++i) {
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }
        return curr;
    }
}