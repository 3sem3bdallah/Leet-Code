class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for item in tokens:
            if item == "+":
                stack.append(stack.pop() + stack.pop())
            elif item == "-":
                second, first = stack.pop(), stack.pop()
                stack.append(first - second)
            elif item == "*":
                stack.append(stack.pop() * stack.pop())
            elif item == "/":
                second, first = stack.pop(), stack.pop()
                stack.append(int(first / second))                
            else:
                stack.append(int(item))
        
        return stack[0]