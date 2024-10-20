class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        s = expression
        i = 0
        
        def helper():
            nonlocal i
            c = s[i]
            i += 1
            
            if c == 't':
                return True
            if c == 'f':
                return False
            if c == '!':
                i += 1  # Skip the '('
                res = not helper()
                i += 1  # Skip the ')'
                return res

            children = []
            i += 1  # Skip the '('
            while s[i] != ')':
                children.append(helper())
                if s[i] == ',':  # Handle commas between arguments
                    i += 1  # Move past the comma
            i += 1  # Skip the ')'
            
            if c == '&':
                return all(children)
            if c == '|':
                return any(children)

        return helper()
