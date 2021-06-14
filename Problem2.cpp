//Time Complexity=O(n)
//Space Complexity = O(n) extra vector taken

int n=nums.size();
    vector<int> dp(n);
    
    
    for(int i=0;i<n;i++)
    {
        if(i-2>=0)
        dp[i]=max(dp[i-2]+nums[i],dp[i-1]);
        else if(i-1>=0)
        dp[i]=max(dp[i-1],nums[i]);
        else
        dp[i]=nums[i];
    }
    return dp[n-1];
}