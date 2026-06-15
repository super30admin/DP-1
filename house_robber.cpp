class Solution {
public:
    int rob(vector<int>& nums) {
    //Appraoch 1 - go exhaustive- all possible value evaluation 

    // TC: 2^n
    // SC: O(n) 
    //     return helper(nums, 0, 0);
    // }
    // int helper(vector<int>& nums, int index, int earned)
    // {
    //     if(index >= nums.size())
    //     {
    //         return earned;
    //     }
    //     //not choose 
    //     int case1=helper(nums, index+1, earned);
    //     //choose
    //     int case2=helper(nums, index+2, earned+nums[index]);

    //     return max(case1, case2);
    // }

    //Approach 2: *******2D array***** dp where we store values of robbings and values when not robbed. if we choose to not rob the current house then the value should come from earlier robbings!! if chose to rob the current house then current house robbing value must be added to the earlier non-robbed value because only alternate hosues can be robbed. in the end we get maximum between both the approaches 

    //  TC: O(n)
    // SC: O(n)

    // int n=nums.size();
    // vector<vector<int>> dp(n,vector<int>(2));
    // dp[0][0]=0;
    // dp[0][1]=nums[0];
    // for(int i=1;i<n;i++)
    // {
    //     dp[i][0]=max(dp[i-1][1], dp[i-1][0]);
    //     dp[i][1]=dp[i-1][0]+nums[i];
    // }
    // return max(dp[n-1][0], dp[n-1][1]);


    //Approach 3: DP with only 2 variables 
    // TC: O(n)
    // SC: O(1)
    int n=nums.size();
    int skip=0, take=nums[0];
    for(int i=1;i<n;i++)
    {
        int temp=skip;
        skip=max(skip, take);
        take=temp+nums[i];

    }
    return max(skip, take);

    }
};
