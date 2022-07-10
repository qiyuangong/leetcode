from collections import defaultdict

class TimeMap(object):

    def __init__(self):
        self.store = defaultdict(list)

    def set(self, key, value, timestamp):
        self.store[key].append((value, timestamp))

    def get(self, key, timestamp):
        values = self.store.get(key, [])
        res = ""

        l = 0
        r = len(values) - 1

        while l <= r:
            mid = (l + r) // 2
            if values[mid][1] <= timestamp:
                l = mid + 1
                res = values[mid][0]
            else:
                r = mid - 1
        
        return res
