number_list = [2, 3, 4, 1, 6]
target = 6

def recurse(index, sum, number_list, target):
    if index >= len(number_list) or number_list[index] == target:
        return sum
    return recurse(index + 1, sum + number_list[index], number_list, target)
        

def return_sum(number_list, target):
    index, result, sum = 0, 0, 0
    result = recurse(index, sum, number_list, target)
    return result

print(return_sum(number_list, target))
