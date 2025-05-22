// TC = O(N) -- we parse through the array only once
// SC = O(N) -- We are having an array of size N+1 for storing the values

// Successfully ran on Leet code
// first assign the value 0 for zero
// Next the frist house as well
//  Now from here we check if the previous is greater than current+ (current-2)
//  Thats because we check only alternate ones if we choose a house.



class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int []dp = new int[n+1];
        dp[0]=0;
        dp[1] = nums[0];
        for(int i=2;i<=n;++i)
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        return dp[n];
    }
}
