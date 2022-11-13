#include <vector>
using namespace std;

class Solution
{
public:
    int rob(vector<int> &nums)
    {
        // define rows and columns m x n
        int m = nums.size();
        int n = 2;
        // define a matrix to solve using dp
        int max_amount[m][n];

        max_amount[0][0] = 0;
        max_amount[0][1] = nums[0];

        for (int i = 1; i < m; i++)
        {

            max_amount[i][0] = max(max_amount[i - 1][0], max_amount[i - 1][1]);
            max_amount[i][1] = nums[i] + max_amount[i - 1][0];
        }

        return max(max_amount[m - 1][0], max_amount[m - 1][1]);
    }
};