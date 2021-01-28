// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // initializing the variables which lets us decide to Chose the house or not
        int choose = nums[0], dontChoose = 0;
        int temp = dontChoose;

        // check all house and decide to rob the house or not
        for (int n = 1; n < nums.length; n++) {
            temp = dontChoose;
            dontChoose = Math.max(choose, dontChoose);
            choose = temp + nums[n];
        }

        // return max value
        return Math.max(choose, dontChoose);

    }
}
