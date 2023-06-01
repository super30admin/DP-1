/*

Space complexity reduced to O(m) which is the amount of target.

*/


#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        vector<int> arr(amount+1);
        const int max_val{INT_MAX - 147483647};

        for(int j{1};j<=amount;++j){
            arr.at(j) = max_val;
        }

        for(int i{1};i<=coins.size();i++){
            for (int j{};j<=amount;j++){
                // case where values are less than the coin value
                if(j>=coins.at(i-1)){
                    int val_1{1+arr.at(j-coins.at(i-1))};
                    int val_2{arr.at(j)};
                    arr.at(j) = (val_2<val_1)?val_2:val_1;
                }
            }
        }
        
        if(arr.at(amount) == max_val) return -1;
        return arr.at(amount);
    
    }
};

/*

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        vector<int> arr(amount+1);

        for(int i{1};i<=amount;i++){
            arr.at(i) = INT_MAX;
            for(int c:coins){
                if(i-c>=0){
                    if (arr[i-c]!=INT_MAX){
                        arr[i] = min(arr[i],1+arr[i-c]);
                    }
                }
            }
        }

        return (arr.at(amount) == INT_MAX)?-1:arr.at(amount);
    
    }
};

*/