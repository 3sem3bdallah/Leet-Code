class Solution:
    def calPoints(self, operations: List[str]) -> int:
        
        score_stack = []
        
        for item in operations:
            
            if item == \+\ and len(score_stack) >= 2:
                summed = score_stack[-2] + score_stack[-1]
                score_stack.append(summed)
                
            elif item == \D\ and len(score_stack) >= 1:
                doubled = score_stack[-1] * 2
                score_stack.append(doubled)
                
            elif item == \C\ and len(score_stack) >= 1:
                score_stack.pop() 
                
            else: 
                score_stack.append(int(item))

        return sum(score_stack)