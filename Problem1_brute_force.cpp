/*

Brute force solution

// Time Complexity : O(2^(m*n)) // number of elements * target value
// Space Complexity : O(2^(m*n)) // space complexity for each call 
// Did this code successfully run on Leetcode : No time complexity error
// Any problem you faced while coding this :

Breaking the problem into small parts and looking at the end leaves of the tree.

// Your code here along with comments explaining your approach

You choose option 0 select coin or option 1 dont select coin for the coin at given index
If you choose coin then subtract the amount from the coin and agan pass onto helper function with new target value.
If the leaves of the tree are -1, target <0 or index exceeding the length of the values then return -1. Not a solution
if(target == 0) then return the number of coins used. From both the case return the least number of coins used.

*/


#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int help(vector<int>& coins,int idx,int amount,int count){
        //base
        if(amount == 0){
            return count;
        }
        if(amount<0 || idx == coins.size()){
            return -1;
        }
        //logic

        int case_1 = help(coins,idx,amount-coins[idx],count+1);
        int case_2 = help(coins,idx+1,amount,count);
        if(case_1 == -1) return case_2;
        if(case_2 == -1) return case_1;

        return ((case_1<case_2)?case_1:case_2);

    }
    int coinChange(vector<int>& coins, int amount) {
        return help(coins,0,amount,0);
    }
};