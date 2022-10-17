/*
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/
class Solution {
public:
    int dp[12][10000+1];
    int coinChange(vector<int>& coins, int amount) {
        int ans= coinC(coins, amount, 0);
        dp[0][amount+1];
        return ans==INT_MAX ? -1: ans;
    }
    
    int coinC(vector<int>& coins, int amount, int index){
        int ans=0;
            //base
                //valid
                if(amount==0){
                    return 0;
                }
                //invalid
                if(amount<0||index==coins.size()){return INT_MAX;}
            //recursive
        if(dp[index][amount]==0){
                //select 
                    int sel = coinC(coins,amount-coins[index], index);
            if(sel!=INT_MAX){
                sel+=1;
            }
                //notselect
                    int notsel = coinC(coins, amount, index+1);
            dp[index][amount] = min(sel,notsel);
        }
        return dp[index][amount];
    }
};