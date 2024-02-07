def getValuesForKey(key,records):
    aList=[]
    for data in records:
        if key in data and data[key] not in aList:
            aList.append(data[key])
    return aList

def countMatchesByKey(key,value,records):
    total=0
    for data in records:
        if key in data and data[key] == value:
            total+=1
    return total

def countMatchesByKeys(key1,value1,key2,value2,records):
    total=0
    for data in records:
        if key1 in data and key2 in data and data[key1]==value1 and data[key2]==value2:
            total+=1
    return total

def filterByKey(key,value,records):
    aList=[]
    for data in records:
        if key in data and data[key]==value:
            aList.append(data)
    return aList

def computeFrequency(key,records):
    aDict={}
    for data in records:
        if key in data:
            updated=data[key]
            if updated in aDict:
                aDict[updated]+=1
            else:
                aDict[updated]=1
    return aDict