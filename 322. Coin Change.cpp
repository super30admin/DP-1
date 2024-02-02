/*
  Time Complexity: O(amount*n) (n = coins length)
  Space Complexity: O(amount)

  Approach: In each iteration, take each coin once and add it to the amounts stored in the dp table (exluding duplicates)
  So if we reach the target amount in kth iteration, the minimum coins needed is k
*/

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int cnt = 0;
        vector<bool> taken(amount+1, 0);
        vector<int> dp = {0};

        //edge case
        if(amount == 0)  return 0;

        while(!dp.empty()){
          vector<int> tmp = {};
          cnt++;

          for(auto change: dp){
            for(auto coin: coins){
              int new_change = change + coin;
              if(new_change == amount)  return cnt;
              if(new_change < amount && !taken[new_change]){
                taken[new_change] = true;
                tmp.push_back(new_change);
              }
            }
          }

          dp = tmp;
        }

        return -1;
    }
};
