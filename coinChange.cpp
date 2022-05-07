//Time = O(MN)
//Space = O(MN)

//Initialize dummy row to 9999 except 1st element
//At each stage we can pick a coin or not pick a coin
//If amount > denominations available ==> we can simply copy the element from previous row
// If not - we find the min of element in above row, element that is denomination cols behind on the same row

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<vector<int>> dp( coins.size()+1 , vector<int> (amount+1));
          
        for(int k=1;k<dp[0].size();k++){
            dp[0][k]=99999;
        }
       
        for(int i=1;i<dp.size();i++){
            for(int j=1;j<dp[0].size();j++){ //j=1 since first col always 0 = ignore
                //coin denomination < amount-- 0 case
                if(j<coins[i-1]){
                    dp[i][j]= dp[i-1][j];
                }else{ //amount < coin denomination -- both cases possible
                    dp[i][j] = std::min(dp[i-1][j], 1+ dp[i][j-coins[i-1]]);
                }
            }
        }
        int result = dp[dp.size()-1][dp[0].size()-1];
        return result >=99999 ? -1 : result;
    }
