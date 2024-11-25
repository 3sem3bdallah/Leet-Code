from typing import List
from collections import deque

class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        target = "123450"
        m, n = len(board), len(board[0])
        
        start = "".join(str(board[i][j]) for i in range(m) for j in range(n))
        directions = [[1, 3], [0, 2, 4], [1, 5], [0, 4], [1, 3, 5], [2, 4]]
        
        visited = set()
        visited.add(start)
        q = deque([start])
        
        count = 0
        
        while q:
            size = len(q)
            for _ in range(size):
                current = q.popleft()
                
                if current == target:
                    return count
                
                zero_index = current.index('0')
                for dir in directions[zero_index]:
                    next_state = list(current)
                    next_state[zero_index], next_state[dir] = next_state[dir], next_state[zero_index]
                    next_str = "".join(next_state)
                    
                    if next_str not in visited:
                        visited.add(next_str)
                        q.append(next_str)
            count += 1
        
        return -1