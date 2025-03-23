// Time Complexity : O(N) N is #of houses. 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : unable to figure out sub problem 


// Your code here along with comments explaining your approach:
// 1. Create an array which keeps track if we are considering that house or not to rob(size=N).
// 2. If previous house is robbed check max value between if this house was robbed or if neighbour house was robbed.
// 3. Answer will be last element.

class Solution {
public:
    int rob(vector<int>& nums) {
        int f=0;
        int a[nums.size()];
        a[0]=nums[0];
        if(nums.size()>1){
            if(nums[1]>nums[0]){
                a[1]=nums[1];
            }else{
                a[1]=nums[0];f=1;
            }
        }
        for(int i=2;i<nums.size();i++){
            if(f==1){
                a[i]=nums[i]+a[i-1];f=0;
            }
            else{
                if( (nums[i]+a[i-2]) > (a[i-1]) ){
                    a[i]=(nums[i]+a[i-2]);f=0;
                }else{
                    a[i]=a[i-1];f=1;
                }
            }
            cout<<a[i]<<' ';
        }
        return a[nums.size()-1];
    }
};