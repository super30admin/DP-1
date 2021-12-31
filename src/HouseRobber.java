public class HouseRobber {
    //Brute Force
    // m = house
    // Time Complexity : O(2^m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
    class Solution {
        public int rob(int[] nums) {
            if(nums == null) return 0;

            return helper(nums, 0, 0);
        }
        private int helper(int nums[], int index, int maxRob) {
            // Base
            if(index >= nums.length) return maxRob;
            // Logic
            int case1 = helper(nums, index+2, maxRob+nums[index]);
            int case0 = helper(nums, index+1, maxRob);
            if(case1 == 0) return case0;
            if(case0 == 0) return case1;
            return Math.max(case1, case0);
        }
    }

    //DP
    // m = houseamount
    // Time Complexity : O(m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
        public int rob(int[] nums) {
            int previous = nums[nums.length-1];
            int previousPrevious = 0;
            for(int i=nums.length-2; i>=0; i--) {
                int temp = Math.max(nums[i]+previousPrevious, previous);
                previousPrevious = previous;
                previous = temp;
            }
            return previous;
        }

}
