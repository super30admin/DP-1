//T : O(M*N)
//S : O(M*N)
class Solution {
public:
    // Recursion solution
    int getMinCoin(vector<int> coins, int amount, int mn, int index){
        if(amount == 0) return mn;
        if(amount<0 || index == coins.size()) return -1;
        
        //Choose
        int case1 = getMinCoin(coins, amount-coins[index], mn+1, index);
        
        //Dont Choose
        int case2 = getMinCoin(coins, amount, mn, index+1);
        
        if(case1 == -1) return case2;
        if(case2 == -1) return case1;
        return min(case1, case2);
        
    }
    
    
    int coinChange(vector<int>& coins, int amount) {
        if(coins.size() == 0) return 0;
        //return getMinCoin(coins, amount, 0, 0);
        
        vector<vector<int>> dp( coins.size()+1,vector<int>(amount+1, 0));
        for(int i=1;i<amount+1;i++){
            dp[0][i] = 999;
        }
       for(int i=1;i<coins.size()+1;i++){
           for(int j=1;j<amount+1;j++){

               //choose
               if(j>=coins[i-1]){ // Amount greater than coin value
                   dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i-1] ] +1 );
               }
               //dont choose (If amount less than coin value) j<coins[i-1]
               else{
                   dp[i][j] = dp[i-1][j];
               }
           }
       }
        if(dp[coins.size()][amount] == 999) return -1;
        else return dp[coins.size()][amount];
        
    }
    
};