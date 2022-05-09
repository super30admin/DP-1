//---------BRUTE FORCE-------------
// Time Complexity :exponential
// Space Complexity :height of tree
// Did this code successfully run on Leetcode :TLE
// Any problem you faced while coding this :no
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)// if input is empty or null
            return 0;
        return helper(nums, 0, 0);
    }

    public int helper(int[] nums, int index, int amount) {// our result depends on index,input and amount
        // base case
        if (index >= nums.length)// if index goes out of bound,return amount
            return amount;
        // logic
        // choose
        int case1 = helper(nums, index + 2, amount + nums[index]);// if we choose current house, we have to leave next
                                                                  // house and amount changes
        // don't choose
        int case2 = helper(nums, index + 1, amount);// if we don't choose current house, amount remains same and we can
                                                    // choose next house
        return Math.max(case1, case2);// we'll return maximum of both
    }
}

// -----------------------OPTIMIZED--------------------
// Time Complexity :O(n)
// Space Complexity :O(n) where n is number of elements in nums array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    public int rob(int[] nums) {

        if (nums == null | nums.length == 0) {
            return 0;
        }
        if (nums.length < 2)
            return nums[0];
        int n = nums.length - 1;
        int[] dp = new int[nums.length];// create new one dimentional array
        dp[0] = nums[0];// if there is one house only, we'll rob that one
        dp[1] = Math.max(nums[0], nums[1]);// if there are two houses only, we'll take maximum of both
        for (int i = 2; i < nums.length; i++) {// now we have two options, to choose and not to choose
            // if I choose current, i need to select i-2 case as i cannot rob two adjacent
            // houses and If i don't choose, I need to take i-1 value {we'll take maximum of
            // both}
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n];
    }
}

// ----------OTHER OPTIMIZED---------------
// Time Complexity :o(N)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    // used variables instead of array
    public int rob(int[] nums) {

        if (nums == null | nums.length == 0) {
            return 0;
        }
        if (nums.length < 2)
            return nums[0];
        int n = nums.length - 1;
        int choose = nums[0];
        int notChoose = Math.max(nums[0], nums[1]);
        for (int i = 2; i <= n; i++) {// we are taking choose and not choose at view of to the next element
            int temp = choose;
            choose = notChoose;
            notChoose = Math.max(notChoose, temp + nums[i]);

        }
        return Math.max(choose, notChoose);
    }
}