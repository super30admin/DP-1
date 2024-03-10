
//time Complexity house robber O(N) and Space Complexity O(1)
class Solution {
    public int rob(int[] nums) {
       if(nums==null || nums.length==0) return 0;
       if(nums.length<2) return nums[0];
       int n = nums.length;

       int[] dp = new int[n];
       dp[0] = nums[0];
       dp[1] = Math.max(nums[0],nums[1]);
       for(int i=2;i<n;i++){
           dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        //    System.out.println(dp[i]);
       }

       return dp[n-1];
    }


}
