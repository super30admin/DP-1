// House_Robber.cpp : This file contains the 'main' function. Program execution begins and ends there.

/*Dynamic programming - botttom-up approach
  Time Complexity - O(N) , N size of array
  Space Complexity - O(N)
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        if (nums.size() == 1)
            return nums[0];
        vector<int> dp(nums.size(), 0);
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for (int i = 2;i < nums.size();i++) {
            dp[i] = max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp.back(); //last element contains the maximum amount
    }
};

int main()
{
    vector<int> nums = { 1,41,1,3,8,21,16 };
    Solution s;
    std::cout << s.rob(nums);"\n";
}