// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Solution-1: House Robber problem, maximum amount of money you can rob
//Brute force approach
//Time complexity: O(2^n)
class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int idx, int totalCost) {

        if(idx >= nums.length) return totalCost;
        // not choose
        int case1 = helper(nums, idx+1, totalCost);

        //choose case
        int case2 = helper(nums, idx+2, totalCost + nums[idx]);

        return Math.max(case1, case2);
    }
}

// Solution-2 House Robber problem, maximum amount of money you can rob: DP array
//Time complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i =2; i< nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[dp.length-1];
    }
}

// Solution-3 using 2 variables
//Time complexity O(n)
//Space complexity: O(1)
class Solution {
    public int rob(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int n = nums.length;
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);

        for(int i = 2; i<nums.length; i++) {
            int temp = curr;
            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }

        return curr;
    }
}

//Solution4: With printing of path taken
class Solution {
    //Time complexity: O(n)
    //Space Complexity: O(1) + O(n) for space for path array
    public int rob(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int n = nums.length;
        boolean[] path = new boolean[n];
        int prev = nums[0];
        path[0] = true;
        int curr = Math.max(nums[0], nums[1]);

        if(Math.max(nums[0], nums[1]) == nums[1]) path[1] = true;
        else path[1] = false;

        for(int i = 2; i<nums.length; i++) {
            int temp = curr;
            
            if(Math.max(curr, nums[i]+prev) == nums[i]+prev) path[i] = true;
            else path[i] = false;

            curr = Math.max(curr, nums[i] + prev);
            prev = temp;
        }

        System.out.println(Arrays.toString(path));
        String out ="";
        for(int i = n-1; i >=0; i -= 2) {
            if(!path[i]) i--;
            if(path[i] == true) out += String.valueOf(nums[i]) + ",";
        }
        System.out.println(out);
        return curr;
    }
}