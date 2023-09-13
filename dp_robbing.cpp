//Time complexity: O(n)
//Space complexity: O(1)

//Approach of uncommented code: simply keep a var for skipping and taking a house, idea is that initially we store values of first house as skip and take 0 and value of house. From there we keep checking conditions where we either skip or take a house
//skip: if you are skipping current house that means we take maximum from the past house's value 
//take: if youre taking it that mean you take skipped value for prior house and add own houses value

class Solution {
public:
    int rob(vector<int>& nums) {
        //Time complexity: O(n)
        //space complexity: O(n)
    /*    int n=nums.size();
        vector<vector<int>> dp(n, vector<int>(2));
        dp[0][0]=0;
        dp[0][1]=nums[0];

        for(int i=1;i<n;i++)
        {
            dp[i][0]=max(dp[i-1][0], dp[i-1][1]);
            dp[i][1]=nums[i]+dp[i-1][0];
        }

        return max(dp[n-1][0], dp[n-1][1]);*/

        int n=nums.size();
        int skip=0;
        int take=nums[0];

        for(int i=1;i<n;i++)
        {
            int temp=skip;
            skip=max(skip,take);
            
            take=temp+nums[i];
        }
        return max(skip,take);
    }
};