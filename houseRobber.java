// Time Complexity : O(n) where n is the length of the nums array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class houseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int chosen = nums[0], notChosen = 0;
        for (int i = 1; i < n; i++) {
            int temp = chosen;
            chosen = notChosen + nums[i];
            notChosen = Math.max(temp, notChosen);
        }
        return Math.max(chosen, notChosen);
    }
}