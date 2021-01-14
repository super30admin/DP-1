Time Complexity : O(n)
Space Complexity : 
Runs on leetCode : NO.

Basic recursive solution but it always gives the wrong answer. Not able to consider all the cases.

#include<iostream>
using namespace std;

class Solution
{
public:
    int coinChange(int coins[], int coinChosen,int sum)
    {
        int n= sizeof(coins)/sizeof(coins[0]);
       if(sum<0)            // If the sum required is less than 0. No solution.
       {
           return 0;
       }
       if(sum==0)       // If sum =0. Solution is 1 as no coin is required.
       {
           return 1;
       }

        if(sum > 0 && coinChosen == n) return 0;

        return coinChange(coins, coinChosen,sum-(coins[coinChosen])) // If the coin is used. Return 1 and sum is subtracted.

               + coinChange(coins, coinChosen + 1,sum);// Next coin is chosen then.
    }

};

int main()
{
    int sum=11;
    int coins[]={1,5,5};
    Solution s;
    int count=s.coinChange(coins,0,4);
    cout<<count;
    return count;

}