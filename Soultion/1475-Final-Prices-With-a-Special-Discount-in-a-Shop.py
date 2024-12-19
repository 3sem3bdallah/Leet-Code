from typing import List

class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        n = len(prices)
        for i in range(n):
            for j in range(i + 1, n):  # Start from the next element after i
                if prices[j] <= prices[i]:  # Find the first price that is <= prices[i]
                    prices[i] -= prices[j]  # Apply the discount
                    break  # Break once we apply the discount
        return prices  # Return the updated prices list
