#Part A
def can_fit_in_room(aDict,num):
    aList=[]
    for key in aDict:
        if aDict[key]<=num:
            aList.append(key)
    return aList
#Part B
def rooms_party_can_fit_in(num,aDict):
    aList=[]
    for key in aDict:
        if aDict[key]>=num:
            aList.append(key)
    return aList
#Part C
def possible_rooms(aDict,bDict):
    cDict={}
    for key in aDict:
        #if aDict[key]<bDict[key]:
        party=aDict[key]
        updated=rooms_party_can_fit_in(party,bDict)
        cDict[key]=updated
    return cDict
print(possible_rooms({"frye":8, "cobb":212, "tam":750}, {"elma":10, "amherst":45, "buffalo":100, "toronto":500}))
print(possible_rooms({},{"elma":10, "amherst":45, "buffalo":100, "toronto":500}))
print(possible_rooms({"frye":8, "cobb":212, "tam":750}, {}))
