// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//1.Edge cases
//2. calculating amount at each house


class Solution {
   int calculate_amount_from_houses(vector<int>& nums){
       
       vector<int> amount_till_that_house(nums.size(),0);
       amount_till_that_house[0]= nums.at(0);
       amount_till_that_house[1]=max(nums.at(0), nums.at(1));
       //2
       for(int j=2; j<nums.size(); j++){
           amount_till_that_house[j] = max((nums[j] + amount_till_that_house[j-2]),(amount_till_that_house[j-1]));
       }
       
       return amount_till_that_house[nums.size()-1];
    }
public:
    int rob(vector<int>& nums) {
    //1
    if(nums.size()==0){
        return 0;
    }
    if(nums.size()==1){
        return nums.at(0);
    }
    if(nums.size()==2){
        return max(nums.at(0), nums.at(1));
    }
        return calculate_amount_from_houses(nums);
    }
};
