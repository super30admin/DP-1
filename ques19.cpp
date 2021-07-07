Time Complexity-O(n*m) where 'm' is the size of the input vector and 'n' is the amount
Space Complexity-O(n) where 'n' is the amount
Did the code run on Leetcode? Yes

#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
	int coinChange(vector<int>& coins, int amount) {
		vector<int>dp(amount+1,amount+1);
		dp[0]=0;
        for(auto x:coins)
        {
            for(int i=x;i<=amount;i++)
            {
                dp[i]=min(dp[i],dp[i-x]+1);
            }
        }
        if(dp[amount]>=amount+1)
            return -1;
        else
            return dp[amount];
	}
};

int main() {
	vector<int>m={1,2,5};
	int target=11;
	Solution soln;
	int result=soln.coinChange(m,target);
	cout<<result;
	return 0;
}
