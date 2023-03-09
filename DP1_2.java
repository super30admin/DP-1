// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Initialize 0 row with 0. 
If the value is 2, we do max between the first and second houses. 
Else, we check the maximum that we get by either skipping that house and considering i-1 or taking it into consideration and adding it with i-2 house. * */

class DP1_2 {
    public int rob(int[] nums) {
   int n = nums.length;
   if(nums==null || n==0) 
   return 0;
   int dp[] = new int[n];
    dp[0] =nums[0];
    if(n > 1)
    dp[1] = Math.max(nums[0],nums[1]);
    for(int i =2; i <n;i++){
        dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
    }
    return dp[n-1];
}
}