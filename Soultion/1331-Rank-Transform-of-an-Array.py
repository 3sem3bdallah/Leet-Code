class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        sorted_unique = sorted(set(arr))
        
        rank_map = {value: rank + 1 for rank, value in enumerate(sorted_unique)}
        
        ranked_array = [rank_map[value] for value in arr]
        
        return ranked_array

# print(array_rank_transform([40, 10, 20, 30]))  # Output: [4, 1, 2, 3]
# print(array_rank_transform([100, 100, 100]))    # Output: [1, 1, 1]
# print(array_rank_transform([37, 12, 28, 9, 100, 56, 80, 5, 12]))  # Output: [5, 3, 4, 2, 8, 6, 7, 1, 3]
