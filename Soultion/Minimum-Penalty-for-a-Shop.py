1class Solution:
2    def bestClosingTime(self, customers: str) -> int:
3
4        x = y = z = 0
5        
6        for i, ch in enumerate(customers):
7            z += 1 if ch == "Y" else -1
8            if z > y:
9                y, x = z, i + 1 
10                
11        return x
12                