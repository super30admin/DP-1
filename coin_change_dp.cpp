// Time complexity O(m X n)
// Space complexity O(m X n)

class Solution
{
public:
    int coinChange(vector<int> &coins, int amount)
    {
        // Implementing a matrix of occurances we are going to solve the problem:
        // Define Dimensions of matrix

        // row
        int m = coins.size() + 1;
        // column
        int n = amount + 1;

        // defining the matrix

        int dp_coin[m][n];
        // setting first column to zero

        for (int i = 0; i < m; i++)
        {
            dp_coin[i][0] = 0;
        }

        // setting first row to infinity
        for (int i = 0; i < n; i++)
        {
            dp_coin[0][i] = amount + 1;
        }

        // iterating over the rows and columns and allocating values

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {

                // check if j is less than coins column

                if (j < coins[i - 1])
                {
                    dp_coin[i][j] = dp_coin[i - 1][j];
                }

                else
                {
                    dp_coin[i][j] = min(dp_coin[i - 1][j], dp_coin[i][j - coins[i - 1]] + 1);
                }
            }
        }

        if (dp_coin[m - 1][amount] == amount + 1)
        {
            return -1;
        }

        else
        {
            return dp_coin[m - 1][amount];
        }
    }
};