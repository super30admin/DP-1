public class HouseRobber {
    //TC:O(N) SC:O(1)
    public int rob(int[] nums) {
        //null
        if(nums == null || nums.length == 0) return 0;
        int prev = 0;
        int curr = nums[0];
        for(int i = 1; i < nums.length;i++) {
            int temp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = temp;
        } 
        return curr;
    }
}

// if(nums == null || nums.length == 0) return 0;
//         int[] dp = new int[nums.length + 1];
//         dp[0] = 0;
//         dp[1] = nums[0];
//         for(int i = 1; i < nums.length;i++) {
//             int val = nums[i];
//             dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
//         } 
//         return dp[nums.length];

// public int rob(int[] nums) {
//         return helper(nums, 0, 0);
//     }

//     private int helper(int[] nums, int i, int amount) {
//         //base
//         if(i >= nums.length) return amount;
//         //logic
//         //case 0
//         int case0 = helper(nums, i+1, amount);
//         //case1
//         int case1 = helper(nums, i+2, amount+nums[i]);

//         return Math.max(case0, case1);
//     }