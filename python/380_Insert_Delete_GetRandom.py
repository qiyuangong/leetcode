import random

class RandomizedSet(object):

    def __init__(self):
        self.num_to_idx = {}
        self.num_list = []

    def insert(self, val):
        if val in self.num_to_idx:
            return False
        else:
            self.num_list.append(val)
            self.num_to_idx[val] = len(self.num_list) - 1
            return True

    def remove(self, val):
        if val not in self.num_to_idx:
            return False

        idx = self.num_to_idx[val]
        last = self.num_list[-1]

        # swap last elem to current spot so you can pop the end
        self.num_list[idx] = last
        self.num_list.pop()
        self.num_to_idx[last] = idx
        del self.num_to_idx[val]

        return True

    def getRandom(self):
        return random.choice(self.num_list)
