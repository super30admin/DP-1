
// This is an exhaustive approach

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        
        return helper(coins,0,amount,0);
    }
    
    int helper(vector<int>& coins,int index, int amount, int min)
    {
        
        //base case:
        //valid path
        if(amount ==0)
        {
            return min;
        }
        //invalid path out of bound
        if(amount<0 or index==coins.size())
        {
            return -1;
        }
        
        
        //case 1: choose:
        int case1= helper(coins, index, amount-coins[index], min+1);
        
        
        //case2: not choose:
        int case2= helper(coins, index+1, amount, min);
        
        
        if(case1==-1)return case2;
        if(case2==-1)return case1;
        
        return std::min(case1,case2);
    }
};

