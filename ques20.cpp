Time Complexity-O(n)
Space Complexity-O(n)
Did the code run on Leetcode? yes

#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==0)
        {
            return 0;
        }
        int n=nums.size()+1;
        int dp[n];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=1;i<nums.size();i++)
        {
            dp[i+1]=max(dp[i],dp[i-1]+nums[i]);
        }
        return dp[nums.size()];
    }
};

int main() {
	vector<int>m={2,7,9,3,1};
	Solution soln;
	int result=soln.rob(m);
	cout<<result;
	return 0;
}