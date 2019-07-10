//
// Created by shazmaan on 7/10/2019.
//

#include <iostream>
#include <algorithm>
#include <map>
#include <vector>

using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        return reccur(0,coins,amount);
    }
private:
    int reccur(int index, vector<int>& coins, int amount){
        if(amount ==0 ){
            return 0;
        }
        if(index<coins.size() && amount>0){
            int max = amount/coins[index];
            int min = INT_MAX;
            for(int x =0; x<=maxVal;x++){
                if(amount>= x*coins.at(index)){
                    int res = reccur(index+1,coins,amount - x*coins[index]);
                    if(res!=-1){
                        min = min(min,res+x);
                    }
                }
            }
            if(min==INT_MAX){
                min = -1;
            }
            return min;
        }
        return -1;
    }
};
//class Solution{
//public:
//    int Prob(vector<int>& nums, int N){
//        int val;
//        for(int x=0; x<nums.size(); x++){
//
//        }
//    }
//    int recur(vector<int>& nums, int N){
//        int sum; int val;
//        if(find(nums.begin(),nums.end(),N)!=nums.end()){
//            return 1;
//        }
//        if(nums[0]!=1 && N%nums[0]==0){
//            val = N/nums[0];
//        }else{
//            val = N-nums[0];
//        }
//
//        if(nums.begin()+1 != nums.end()){
//            vector<int> newVec{nums.begin()+1,nums.end()};
//            sum+=recur(newVec,val)+1;
//        }
//        if(sum>0){return sum;}
//        return -1;
//    }
//};
//1,2,2 (8)

int main(){
    Solution s;
    vector<int> vec{1,2,3};
    return 0;
}
