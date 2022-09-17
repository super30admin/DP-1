import java.util.*;

public class problem2 {

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
public int rob(int[] nums) {
    int[] dp = new int[nums.length+1];
    Arrays.fill(dp,-1);
    
    return helper(0,nums,dp);
}
public int helper(int x, int[] nums,int[] dp){
    int ans=0;
    
    if(x>nums.length-1) return 0;
    if(dp[x]!=-1) return dp[x];
    
    int even = nums[x]+helper(x+2,nums,dp);
    int odd = helper(x+1,nums,dp);
    
    ans = Math.max(ans,Math.max(even,odd));
    
    return dp[x]=ans;
}
}
