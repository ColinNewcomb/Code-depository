#Part A
def how_many_singletons(aList):
    total=0
    for x in range(len(aList)):
        if (len(aList[x])) == 1:
            total+=1
    return total

print(how_many_singletons([]))
print(how_many_singletons(["a","an","I","you","the"]))
print(how_many_singletons(["One","Two"]))
        
#Part B
def sum_of_index_matching_lengths(aList):
    total=0
    for x in range(len(aList)):
        if x == (len(aList[x])):
            total+=x
    return total
print(sum_of_index_matching_lengths([]))
print(sum_of_index_matching_lengths(['a',"an","I","you","then"]))
print(sum_of_index_matching_lengths(["","a","aa","aaa","aaaa"]))

#Part C
def running_length(aList):
    bList=[]
    total=0
    for x in range(len(aList)):
        total+=(len(aList[x]))
        bList.append(total)
    return bList

print(running_length([]))
print(running_length(["a","b","c","d","e"]))
print(running_length(["a","an","I","you","the"]))
