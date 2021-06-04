//Time Complexity: O(n)
//Space Complexity: O(1)
//Leetcode 198
class Solution {
  
    
    //Code with O(1) space
     public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        int prevSum=0, currSum=0, sum=0;
        currSum=nums[0];
        // Formula: sum[i]=Max(  num[i] +  sum[i-2], sum[i-1]);
        for(int i=2;i<n+1;i++)
        {
           sum=Integer.max(prevSum+nums[i-1],currSum);
            prevSum=currSum;
            currSum=sum;
        }
        return currSum;
    }
    
    //Code with O(n) space
    
     /* public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        int[] dp=new int[n+1];
        dp[1]=nums[0];
        // Formula: sum[i]=Max(  num[i] +  sum[i-2], sum[i-1]);
        for(int i=2;i<n+1;i++)
        {
            dp[i]=Integer.max(dp[i-2]+nums[i-1],dp[i-1]);
        }
        return dp[n];
    }*/
}