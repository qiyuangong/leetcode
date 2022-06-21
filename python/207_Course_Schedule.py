from collections import defaultdict

class Solution(object):
    # Adapted from https://youtu.be/yPldqMtg-So

    def hasCycle(self, course, deps, visited, tracker):
        visited.add(course)
        tracker.add(course)
        for n in deps[course]:
            if n not in visited and self.hasCycle(n, deps, visited, tracker):
                return True
            if n in tracker:
                return True
        tracker.remove(course)
        return False

    def canFinish(self, numCourses, prerequisites):
        deps = defaultdict(set)
        for course, pre in prerequisites:
            deps[pre].add(course)

        visited = set()
        for course in range(numCourses):
            tracker = set()
            if self.hasCycle(course, deps, visited, tracker):
                return False
        
        return True
