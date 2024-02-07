#Problem 1
def q1(aDict):
    MaxValue=float("-inf")
    for key in aDict:
        if MaxValue < aDict[key]:
            MaxValue=aDict[key]
    return MaxValue

#Problem 2
def q2(aDict,num):
    aList=[]
    for key in aDict:
        if aDict[key] == num:
            aList.append(key)
    return aList

#Problem 3
def q3(aList,string):
    bList=[]
    for dictionary in aList:
        if string in dictionary:
            bList.append(dictionary)
    return bList

#Problem 4
def q4(aList,num):
    bList=[]
    for dictionary in aList:
        if num in dictionary.values():
            bList.append(dictionary)
    return bList

#Problem 5
def q5(aDict,bDict):
    cDict={}
    for key, value in aDict.items():
        cDict[key]= value
    for key, value in bDict.items():
        if key in cDict:
            cDict[key] += value
        else:
            cDict[key] = value
    return cDict

#Problem 6
def q6(aDict,bDict):
    cDict={}
    for key in aDict.keys():
        if key in bDict:
            cDict[key]=[aDict[key],bDict[key]]
    return cDict

#Problem 7
def q7(filename):
    aList=[]
    with open(filename,"r") as fp:
        for line in fp:
            words=line.split(' ')
            for word in words:
                word = word.strip()
                if word and word not in aList:
                    aList.append(word)
    return aList

#Problem 8
def q8(inputfile,outputfile):
    with open(inputfile,"r") as intf:
        with open(outputfile,"w") as outf:
            for data in intf:
                outf.write(data)
    return outputfile
