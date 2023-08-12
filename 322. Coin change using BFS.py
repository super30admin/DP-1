# Time Complexity: O(coins * amount), where 'coins' is the number of coin denominations and 'amount' is the target amount.
# In the worst case, each node in the BFS queue may be expanded 'coins' times.

# Space Complexity: O(amount), for the BFS queue and the 'visited' set, both of which can hold up to 'amount' elements.

from collections import deque

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Initialize a queue for BFS and a set to keep track of visited amounts
        queue = deque([(amount, 0)])  # (remaining amount, number of coins used)
        visited = set()
        
        while queue:
            curr_amount, coins_used = queue.popleft()
            
            # If the current amount is 0, we've reached a valid combination
            if curr_amount == 0:
                return coins_used
            
            # Explore the possible coin selections
            for coin in coins:
                next_amount = curr_amount - coin
                if next_amount >= 0 and next_amount not in visited:
                    queue.append((next_amount, coins_used + 1))
                    visited.add(next_amount)
        
        # If no valid combination is found
        return -1
