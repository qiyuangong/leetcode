class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        # remove "0b" in front of num1, num2
        num1, num2 = bin(num1)[2:], bin(num2)[2:]
        lenNum1, lenNum2 = len(num1), len(num2)
        ones = num2.count("1")
        maxLen = max(lenNum1, lenNum2)

        # ans list have elements same as the maxLen
        ans = []
        for _ in range(maxLen):
            ans.append("0")

        # add "0" in front of the binary numbers to make indexing easier
        for _ in range(maxLen - lenNum1):
            num1 = "0" + num1

        for _ in range(maxLen - lenNum2):
            num2 = "0" + num2

        # now make "x XOR num1" minimal
        # fill the ans list from index "0"
        # because XOR give 0 when the elements are same.
        for i in range(len(num1)):
            if num1[i] == "1" and ones:
                ans[i] = "1"
                ones -= 1

        # if we still got "1" to fill in the ans list.
        # "1" need to be fill from the back of ans list.
        # to maintain the number small.
        for i in range(len(ans) - 1, -1, -1):
            if ones < 1:
                break

            if ans[i] == "1":
                continue

            ans[i] = "1"
            ones -= 1

        # make the ans in string
        ans = "".join(ans)
        return int(ans, 2)
