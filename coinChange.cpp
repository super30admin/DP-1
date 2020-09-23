//time complexity: O(n)
//space complexity:O(1)
//approach: brute force
//solved on leetcode? yes, but only 35/182 test cases pass
//problem faced? yes, I could not think of any other approach, specially dp approach.
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
     
        int sum=0;
        for(int i=coins.size()-1; i>=0; i--)
        {
            int x=amount/coins[i];
            amount=amount%coins[i];
            sum+=x;
        }
        return sum;      
    }
};