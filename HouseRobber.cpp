#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
A more efficient solution where you dont even have to declare a new dp array 
decalre two variables prev and curr and take out the max value you can reach and 
return the current max value
*/
class Solution{
public:
    int rob(vector<int>& nums) {
        int n=nums.size();
        if(n==1) return nums[0];
        

        int prev = nums[0];
        int curr = max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            int temp = curr;
            curr = max(curr, nums[i]+prev);
            prev = temp;
        }
        return curr;
    }
};
