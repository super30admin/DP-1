class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
         int n = coins.size();
        // vector<vector<int>> dp(coins.size(),vector<int>(amount));
         

        int dp[n+1][amount+1];
         dp[0][0] = 0;
        for(int j=1;j<=amount;j++){
            dp[0][j] = 99999;
     
        }
          for(int i=1;i<=n;i++){
            dp[i][0]  = 0;
         }

        
         for(int i=1;i<=n;i++){
              for(int j=1;j<=amount;j++){
                    if(coins[i-1]>j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                        
                    }
              }
        }

          
          if(dp[n][amount] >= 99999) return -1;
            return dp[n][amount];

           

    }

};








//        return coin(coins,0,amount,0);

//     }

//  int coin(vector<int> coins, int idx,int amount, int coinUsed){

//             if(amount == 0){
//                 return coinUsed;
//             }
//             if( idx == coins.size() || amount<0 ){
//                 return -1;
//             }

//                 int case1 = coin(coins,idx,amount-coins[idx],coinUsed+1);
//                 int case2 = coin(coins,idx+1,amount,coinUsed);
//                 if(case1 == -1) return case2;
//                 if(case2 == -1) return case1;
//                 return min(case1,case2);
                   
//     }