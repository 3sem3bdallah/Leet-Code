class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        # Step 1: pair each element with its original index
        indexed = list(enumerate(nums))  # (index, value)
        
        # Step 2: get k elements with the largest values
        top_k = sorted(indexed, key=lambda x: x[1], reverse=True)[:k]
        
        # Step 3: sort the selected elements by original index
        top_k_sorted = sorted(top_k, key=lambda x: x[0])
        
        # Step 4: extract the values only
        return [val for idx, val in top_k_sorted]
