//
// Created by shazmaan on 7/10/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>


//{6, 7, 1, 3, 8, 2, 4}
//{5, 3, 4, 11, 2}

using namespace std;

class Solution{
public:
    std::min
    int prob(vector<int>& nums){
        int index = 2; int sum=nums[0];
        while(index<nums.size()){
            if(index+2<nums.size()){
                if(nums[index+1]>nums[index]){
                    if(nums[index+1]<nums[index+2]){
                        sum+=nums[index];
                    }else{sum+=nums[index+1];}
                }else{sum+=nums[index];}
            }else if(index+1<nums.size()){
                if(nums[index+1]>nums[index]){
                    sum+=nums[index+1];
                }else{sum+=nums[index];}
            }else{
                if(index-1>=0 && nums[index-1]>nums[index]){
                    if(index-2>=0 && nums[index-2]>nums[index]){
                        sum+=nums[index];
                    }
                }
            }
            index+=2;
        }
        return sum;
    }
};

int main(){
    Solution s;
    vector<int> vec{5, 3, 4, 11, 2};
    vector<int> vec2{6, 7, 1, 3, 8, 2, 4};
    vector<int> vec3{1,2,3,1};
    vector<int> vec4{2,7,9,3,1};
    cout<<s.prob(vec)<<endl;
    return 0;
}