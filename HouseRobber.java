/** Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
* Time complexity O(n) Space complexity O(1)
* Each house update the skip and rob values. Skip is Max of previous (rob,skip) and rob is sum of previous skip and current house value.  
*/
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        int skip = 0, rob = nums[0];
        for (int i = 1; i< nums.length; i++)
        {
            int temp = skip;
            skip = Math.max(skip,rob);
            rob = temp + nums[i];
        }
        return Math.max(skip, rob);
    }
}
