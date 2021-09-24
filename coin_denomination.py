from collections import OrderedDict


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        tot_amt = amount
        n = len(coins)
        max_coins_dict_ = OrderedDict()

        for coin_idx in range(len(coins)-1, -1, -1):
            multiplier = 0
            while multiplier * coins[coin_idx] <= amount:
                multiplier += 1
            max_coins_dict_[coins[coin_idx]] = multiplier - 1
        result = 0
        print(max_coins_dict_)
        curr_sum = 0
        for coin in max_coins_dict_:
            if amount >= curr_sum:
                curr_sum = max_coins_dict_[coin] * coin
                result += max_coins_dict_[coin]
        if amount == curr_sum:
            return result
        else:
            return -1


'''
1. I tried to make a dictionary with
key : coin value 
value : max number of coins from that key needed to produce a sum that is less than or equal to the amount
2. I then iterated over the dictionary to find the min no of coins needed to produce the given amount

'''
