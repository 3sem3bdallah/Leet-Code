1class Solution:
2    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
3        az=sum(apple)
4        for i, x in enumerate(sorted(capacity, reverse=True)):
5            az-=x
6            if az<=0: return i+1
7        return -1
8        