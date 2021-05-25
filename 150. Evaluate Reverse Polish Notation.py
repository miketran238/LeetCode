class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for t in tokens:
            if t == "+" or t == "-" or t == "*" or t == "/":
                second = int(stack.pop())
                first = int(stack.pop())
                res = 0
                if t == "+": res = first + second
                if t == "-": res = first - second
                if t == "*": res = first * second
                if t == "/": res = int(first/second)
                stack.append(res)
                #print(res)
            else:
                stack.append(t)
        return stack[0]
