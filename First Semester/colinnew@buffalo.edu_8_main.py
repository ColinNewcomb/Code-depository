#Part A
def partA(aList):
    total=0
    if len(aList) == 0:
        return 0
    else:
        for x in range(len(aList)):
            total+=aList[x]
            num=total/len(aList)
            r=round(num,2)
    return r
#part C
def partC(aList):
    for x in range(len(aList)):
        if (x%2 == 0):
            aList[x]=aList[x]*aList[x]
    return None
#part B

def partB(bList,n):
    cList=[]
    for x in range(-1,len(bList),n):
        new=bList[x-n]
        if new not in cList:
             cList.append(new)
    return cList
print(partB(["a", "aa", "aaa"], 1))

