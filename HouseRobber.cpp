class Solution {
public:
    int rob(vector<int>& nums) {
        int n= nums.size();
        
        vector<int> maxSize (n+1,0);
        if(n==2){
            return max(nums[0],nums[1]);
        }
        if (n==1){
            return nums[0];
        }
        maxSize[n]=0;
        for(int i= 0;i<n;i++){
            maxSize[i] = nums[i];
        }
        
        for(int i= n-2;i>=0;i--){
            maxSize[i] = max(maxSize[i]+maxSize[i+2],maxSize[i+1]);        
        }
        return maxSize[0];
        
    }
};