# Created by Aashish Adhikari at 5:19 PM 1/5/2021

'''
Time Complexity:
In this naive recursive solution, at each node, we either take this particular coin or we do not take it. Hence, 2 branches at each node.
In the worst case, there is just 1 coin of denomination 1. Hence, the height of the tree becomes equal to the amount. If some other coin k is the
least denomination, the height becomes (amount/k).
However, there are other nodes that need to be explored as well, but they wont go beyond the max length.

Hence assuming that in the worst case all the paths to the leaves are of length equal to max length, we can see that the number of ndoes doubles
at each new level. Hence the time complexity is O ( # of branches from each node ^ (max height possible) ) = O ( 2 ^ (amount / least denomination))
                                                                                                            ~ O (2 ^ (amount))


Space Complexity:
O(2 ^ amount) since we create new variables at each recursive call.
'''



class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        return self.helper(coins, amount, 0, 0)


    def helper(self, coins, amount, index, current_min):

        # Recursion base case
        if amount == 0:
            return current_min
        if amount < 0 or index == len(coins):
            return  -1


        # case when u dont take the coin
        case1 = self.helper(coins, amount, index+1, current_min)


        # case when u take the coin
        case2 = self.helper(coins, amount - coins[index], index, current_min + 1)

        # Handle the base cases' return
        if case1 == -1:
            return case2
        if case2 == -1:
            return case1

        min_among_two_options = min(case1, case2)

        return min_among_two_options





