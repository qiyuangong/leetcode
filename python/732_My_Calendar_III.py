from sortedcontainers import SortedDict


class MyCalendarThree:
  def __init__(self):
    self.timeline = SortedDict()

  def book(self, start: int, end: int) -> int:
    self.timeline[start] = self.timeline.get(start, 0) + 1
    self.timeline[end] = self.timeline.get(end, 0) - 1

    ans = 0
    activeEvents = 0

    for count in self.timeline.values():
      activeEvents += count
      ans = max(ans, activeEvents)
