//Time complexity O(N). where N is the total no.of houses in the street.
//Space complexity O(1)
//The code run successfully in leet code
//I have gone through the bottom up approach



class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int choose=nums[n-1],dnc=0;//I have kept the last element as it is
        for(int i=n-2;i>=0;i--)//started iterating backwards from last but one element
        {
            nums[i] = Math.max(choose,nums[i]+dnc);//I calculated the max amount I can get at the index i. It is between when we choose the 
            //element and when we don not choose the element.
            //first parameter(when we do not choose): we can choose the next element. so the first paramenter will be nums[i+1] and
            //second parameter is when we choose it: we  cannot choose the next element: so it will be nums[i]+ amt if we do not choose the next element.
            dnc=choose;
            choose=nums[i];
            
        }
        int maxmoney;//now we have to calculate the maximum value in the total array to find the maximum amount that can be robbed.
        int maxmoney;
        Arrays.sort(nums);//sort it and return the last element which is the max
        return nums[n-1];//return the maximum money
            
            
            
            }
}