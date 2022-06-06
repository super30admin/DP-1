// Bottom up dp
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
class HouseRobber {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp = new int[n];

        // Initialize the dp array
        // we need (i - 2) amount so we need to initialize first 2 places
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // start from 2
        for (int i = 2; i < n; i++) {

            // Take max from not choose and choose
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);

        }

        return dp[n - 1];
    }

}

// Space Optimized
// Time Complexity : O(N)
// Space Complexity : O(1) :: we are using only 2 variables now
// Did this code successfully run on Leetcode : yes
class HouseRobber {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        if (n == 1) return nums[0];

        // Initialize the dp array
        // we need (i - 2) amount so we need to initialize first 2 places
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        // start from 2
        for (int i = 2; i < n; i++) {

            int temp = curr;
            // Take max from not choose and choose
            curr = Math.max(curr, nums[i] + prev);

            prev = temp;
        }

        return curr;
    }

}

//This is Exhaustive approach based on Pick and Non-pick
// Time Complexity : O(2 ^ N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : No -> Getting Time limit exceeded error
/*
class HouseRobber {

    private int helper(int[] nums, int index, int money) {

        if(index >= nums.length) return money;

        // chose the house
        // next house will be +2 as you cannot choose adjacent house
        int i = helper(nums, index + 2, money + nums[index]);

        // not choose
        int j = helper(nums, index + 1, money);

        return Math.max(i, j);
    }

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        return helper(nums, 0, 0);

    }

}
*/
