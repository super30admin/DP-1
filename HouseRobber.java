//Leetcode Question - 198 - House Robber
/**Algorithm - DP
 * Skip or take for a given house
 * If you skip - the sum currently is max of the past house
 * else sum = max of the sum of this house and the past sum
 */
/**TC - O(N)
 * SC - O(N)
 */

public class HouseRobber {
    class Solution {
        public int rob(int[] nums) {
            if(nums== null || nums.length == 0){
                return 0;
            }
            int skip = 0, take = nums[0];
            for(int i =1; i<nums.length; i++){
                int temp = skip;
                skip = Math.max(skip,take);
                take = temp + nums[i];
            }
            return Math.max(skip, take);
        }
}
