/*
This program solves the coin change problem using dynamic programming approach. It first
constructs a solution space, wherein it tracks the minimum number of coins needed to make
change for a particular amount. It does so by successively tracking minimum number of coins 
for each number of denomiations available, for each amount successively starting from 0 uptil
the current given amount. The logic behind this is to solve the subproblems and find the 
optimal solution for smaller denominations and amounts, and use that to build up to the
final answer.


Problems with this approach: It does not check if the amount of money cannot be made by any
combination of coins. There is also an index out of bounds error when trying to solve some of
the subproblems viz. when the coins[i] > j at line 57.

Did this code run on leetcode: No

*/



class Solution {
public:
    //Function for finding minimum 
    int min(int a, int b)
    {
        if(a < b)
            return a;
        return b;
    }
    //Time Complexity: O(no. of coins * amount)
    //Space Complexity: O(no. of coins * amount)
    int coinChange(vector<int>& coins, int amount) 
    {
        int size = coins.size();
        int money[size][amount+1];
        
        int i = 0;
        //Constructing base cases for when the amount = 0
        while(i < size)
        {
            money[i][0] = 0;
            i++;
        }
        
        for(i = 0; i < size; i++)
        {
            for(int j = 1; j < amount + 1; j++)
            {   //Constructing base cases for when we are on the first denomination
                if(i == 0)
                    money[i][j] = j / coins[i];
                //When current denomination is higher than current amount, use solution at previous denomination with same amount
                if(j < coins[i])
                    money[i][j] = money[i - 1][j];
                /*Calculate solution by taking the minimum of adding a coin and subtracting the denomination from the current amount
                and using solution at subtracted amount, or using solution at previous denomination with the same amount*/
                else
                    money[i][j] = min(1 + money[i][j - coins[i]], money[i - 1][j]);
            }
        }
        /*The solution is stored at the lower right corner of the solution space, 
        where the given amount is checked against all denominations*/
        return money[size - 1][amount];
        
    }
};