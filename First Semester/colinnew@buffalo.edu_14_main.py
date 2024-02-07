#1
def partA(aList):
    total=0
    for x in range(len(aList)):
        if aList[x]<0:
            total+=1
    return total
#2
def partB(aList):
    bList=[]
    for x in range(len(aList)):
        if x%2 == 0:
            bList.append(len(aList[x]))
    return bList    
#3
def partC(aList):
    for x in range(len(aList)):
        if x%2 != 0:
            something=aList[x]
            word=aList[x]
            new=str(len(aList[x]))
            something.replace(new,"")
    return None

print(partC(["", "a", "aa", "aaa", "aaaa"]))
    

            
