// Time Complexity: O(N)Where N is no of elements in the array.
// Space Complexity: O(2N) or O(N) where N is th eno of elements in the array.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No




class Solution {
public:
    int rob(vector<int>& nums) {
        
    if(nums.size()==0)return 0;
    int rows = nums.size();
    int cols = 2;
    int t[rows][cols]; //2 cols // 0-> rob the house//1->dont rob
    t[0][0] = nums[0];
    t[0][1] = 0;
    for(int i = 1; i < rows;i++){
        for(int j = 0; j < cols;j++){
            if(j ==0){
                t[i][j] = nums[i]+t[i-1][1];
            }
            else{
                t[i][j] = max(t[i-1][0],t[i-1][1]);
            }
        }
    }
    return max(t[rows-1][0],t[rows-1][1]);
    }

  
};