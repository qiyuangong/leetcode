class Solution:
    def countDaysTogether(self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str) -> int:
        # split the dates to month and day.
        arriveAliceMonth, arriveAliceDay = map(int, arriveAlice.split("-"))
        leaveAliceMonth, leaveAliceDay = map(int, leaveAlice.split("-"))
        arriveBobMonth, arriveBobDay = map(int, arriveBob.split("-"))
        leaveBobMonth, leaveBobDay = map(int, leaveBob.split("-"))

        # prefixOfCalendar : initialize the calendar and in the past we will use this to convert month to day, index is 1 - based
        # spentTogether, aliceSpent : work as cache list. and index is 1 - based
        calendar = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        prefixOfCalendar = [0] * 13
        totalDates = sum(calendar)
        spentTogether, aliceSpent = [0] * (totalDates + 1), [0] * (totalDates + 1)

        # calculate the prefix of calendar
        for i in range(1, len(calendar)):
            prefixOfCalendar[i] = prefixOfCalendar[i - 1] + calendar[i]

        # if the string is "01-15", it can be treat as 15 days.
        # if the string is "02-27", it can be treat as 58 days.
        # So, it can be "prefixOfCalendar[month - 1] + day"
        # and in the problem it includes the leaveDate so +1 need to be in .
        arriveAliceTotal = prefixOfCalendar[arriveAliceMonth - 1] + arriveAliceDay
        leaveAliceTotal = prefixOfCalendar[leaveAliceMonth - 1] + leaveAliceDay
        for i in range(arriveAliceTotal, leaveAliceTotal + 1):
            aliceSpent[i] += 1

        # check the aliceSpent[i] is True.
        # if it is, they spentTogether is True too.
        arriveBobTotal = prefixOfCalendar[arriveBobMonth - 1] + arriveBobDay
        leaveBobTotal = prefixOfCalendar[leaveBobMonth - 1] + leaveBobDay
        for i in range(arriveBobTotal, leaveBobTotal + 1):
            if aliceSpent[i]:
                spentTogether[i] += 1

        # I used list because of this sum function.
        return sum(spentTogether)
