// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class HouseRobbing {
    class Solution {
        public int rob(int[] nums) {
            int numsSize = nums.length;
            int prev1 = nums[0], prev2  = 0;

            for(int i = 1; i < numsSize; i++){
                int notRob = prev1;
                int rob = nums[i];
                if(i > 1){
                    rob += prev2;
                }
                int cur = Math.max(rob, notRob);
                prev2 = prev1;
                prev1 = cur;
            }
            return prev1;
        }
    }
}
