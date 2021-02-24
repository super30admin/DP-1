//TC: O(n)  where n is number of elements
//SC: O(1)

class Solution {
public:
    int rob(vector<int>& nums) {
        
        //base case is first 2 houses' money. Then, we check which one among third house's money + house from 2 positions away and current sum is greater, and assign new current sum to that. 
    
        if(nums.size() == 0)
            return 0;
        if(nums.size() == 1)
            return nums[0];
        
        if(nums.size() == 2)
            return max(nums[0], nums[1]);
        
        //assign zeroth to prev
        int prev_max = nums[0];
        //assign first to current
        int curr_max = max(prev_max, nums[1]);
        
        for(int i=2; i<nums.size(); i++){
            //set a temp equal to current.
            int temp = curr_max;
            //check if prev + new is greater than current_max
            curr_max = max(curr_max, prev_max + nums[i]);
            //cout<<curr_max<<endl;
            prev_max = temp;
        }
            
        return curr_max;

                
    }
};