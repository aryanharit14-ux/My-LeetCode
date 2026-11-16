class Solution:
    def myAtoi(self, s: str) -> int:
        i, sign, num = 0, 1, 0
        n = len(s)
        INT_MIN, INT_MAX = -2**31, 2**31 - 1

        while i < n and s[i] == ' ':
            i += 1

        if i < n and s[i] in '+-':
            sign = -1 if s[i] == '-' else 1
            i += 1

        while i < n and s[i].isdigit():
            num = num * 10 + int(s[i])

            if sign * num <= INT_MIN:
                return INT_MIN
            if sign * num >= INT_MAX:
                return INT_MAX

            i += 1

        return sign * num
