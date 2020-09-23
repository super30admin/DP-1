//time complexity: O(n)
//space complexity:O(n)
//approach: brute force
//solved on leetcode? yes, but only 39/69 test cases pass
//problem faced? yes, I could not think of any other approach, specially dp approach.
//approach 1
class Solution {
public:
    int rob(vector<int>& nums) {
        int sume=0;
        int sumo=0;
        if(nums.size()==0)
        {
            return 0;
        }
        for(int i=0; i<nums.size(); i+=2)
        {
            sume+=nums[i];
        }
        for(int i=1; i<nums.size();i+=2)
        {
            sumo+=nums[i];
        }
        return max(sume,sumo);
    }
};


//approach 2
//0/69 test cases pass but it is closer to dp approach
class Solution {
public:
    int rob(vector<int>& nums) {
        int sum=0;
        int max1=0, max2=0, max3=0;
        for(int i=0;i<nums.size()-2;i++)
        {
            max1=nums[i]+nums[i+2];
            max2=max(nums[i],nums[i+1]);
            max3=max(max1,max2);
            sum=sum+max3;
            //max1=0; max2=0;max3=0;
        }
        return sum;
    }
};


//approach 3
//saw the solution
class Solution {
public:
    int rob(vector<int>& nums) {
        int prevmax=0;
        int curmax=0;
        for(int i=0; i<nums.size(); i++)
        {
            int temp=curmax;
            curmax=max(prevmax+nums[i],curmax);
            prevmax=temp;
        }
        return curmax;
    }
};