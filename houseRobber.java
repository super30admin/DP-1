/** time complexity: O(n) where n is the length of the input array
 * space complexity: only O(1) as we are using constant space for prev and curr variables
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
 /** 
  * The base case is handles by returning nums[0] if the length if there is only one house to rob.
  * When a house is not robbed, then the maximum amount that can be robbed is the maximum amount from all the other houses considered so far including the adjacent i.e., previous house.
  * When a house is robbed, then the maximum amount that can be robbed is the current house's value plus the maximum amount robbed from all the houses considered so far excluding the adjacent i.e., previous house.
  * The maximum of these two values is stored in the curr variable.
  * Finally, the curr variable is returned as the result as it contains the maximum amount that can be robbed from all the houses considered.
  */


class houseRobber {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        if (n==1)
        {
            return nums[0];
        }
        int prev=nums[0];
        int curr=Math.max(nums[0],nums[1]);
        for(int i=2;i<=n-1;i++)
        {
           int temp=curr;
           curr=Math.max(curr,nums[i]+prev);
           prev=temp;
        }

        return curr;
        
    }
}