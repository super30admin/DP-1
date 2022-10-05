
// Exhaustive approach - Runtime exceeded for some cases
public class HouseRobber {
    public int rob(int[] nums) {
        // null check
        if(nums==null || nums.length==0) return 0;
        return helper(nums,0,0);
    }
    private int helper(int[] nums, int amount, int idx){
        // base
        if(idx>=nums.length) return amount;
        
        // logic
        int case1 = helper(nums,amount+nums[idx],idx+2);
            
        int case0 = helper(nums,amount,idx+1);
        
        return Math.max(case1,case0);
        
    }
}

// Time Complexity - O(2 power n)
// Space Complexity - O(2 power n)

// Optimized DP Solution using 1-d Array
public class HouseRobberDP1 {
    public int rob(int[] nums) {
        // null check
        if(nums==null || nums.length==0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        if(n==1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1];
}
}
// Optimized DP Solution using prev and curr pointers
public class HouseRobberDP2 {
    public int rob(int[] nums) {
        // null check
        if(nums==null || nums.length==0) return 0;
        int n = nums.length;
        if(n==1) return nums[0];
        int prev = nums[0];
        int curr = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int temp = curr;
            curr = Math.max(curr, prev+nums[i]);
            prev = temp;
        }
        return curr;
}
}

// Time Complexity - O(n)
// Space Complexity - O(1)