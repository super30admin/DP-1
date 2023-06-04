#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        vector<vector<int>> arr(coins.size()+1,vector <int> (amount+1));
        const int max_val{INT_MAX - 147483647};

        for(int j{1};j<=amount;++j){
            arr.at(0).at(j) = max_val;
        }

        for(int i{1};i<=coins.size();i++){
            for (int j{};j<=amount;j++){
                // case where values are less than the coin value
                if(j<coins.at(i-1)){
                    arr.at(i).at(j) = arr.at(i-1).at(j);
                }
                else if(j>=coins.at(i-1)){
                    int val_1{1+arr.at(i).at(j-coins.at(i-1))};
                    int val_2{arr.at(i-1).at(j)};
                    arr.at(i).at(j) = (val_2<val_1)?val_2:val_1;
                }
            }
        }
        
        if(arr.at(coins.size()).at(amount) == max_val) return -1;
        return arr.at(coins.size()).at(amount);
    
    }
};
