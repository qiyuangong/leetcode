# class Solution(object):
#     def isValid(self, s):
        
#
class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        pairs={"(":")","[":"]","{":"}"}
        stack = []
        for i in range(len(s)):
            if s[i] in pairs.keys():
                stack.append(s[i])
            else :
                try:
                    if pairs[stack[-1]] == s[i]:
                        stack.pop()
                    else:
                        return False
                except:
                    return False
        if stack == []:
            return True
        else :
            return False
        

    # def isValid(self, s):
    #     # python replace
    #     n = len(s)
    #     if n == 0:
    #         return True
    #
    #     if n % 2 != 0:
    #         return False
    #
    #     while '()' in s or '{}' in s or '[]' in s:
    #         s = s.replace('{}', '').replace('()', '').replace('[]', '')
    #
    #     if s == '':
    #         return True
    #     else:
    #         return False
