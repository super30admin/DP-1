// Time Complexity : n
// Space Complexity : log(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * House robber using skip and take
 */
// Your code here along with comments explaining your approach

public class DpSolRob {
    public int rob(int[] nums) {

        int skip = 0;
        int take = 0;
        if (nums == null || nums.length < 1) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }

        return Math.max(skip, take);
    }
}
