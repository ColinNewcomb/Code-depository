#1
def postage(ounces):
    if (ounces<0):
        return None
    if (ounces<=1):
        return 0.66
    if (ounces<=2):
        return 0.90
    if (ounces<=3):
        return 1.14
    if (ounces<=3.5):
        return 1.38
    else:
        return None
    return round(ounces,2)
#2
def bp_category(diastolic,systolic):
    if diastolic<80 and systolic<120:
        return "normal"
    if diastolic<80 and 120<=systolic<=129:
        return "elevated"
    if diastolic>=90 or systolic>=140:
        return "hypertension stage 2"
    if 80<=diastolic<90 or 130<=systolic<140:
         return "hypertension stage 1"
#3
def first_longest(aList):
    longest=-1
    for x in range(len(aList)):
        if len(aList[x]) > longest:
            longest=len(aList[x])
            word=aList[x]
    return word
#4
def last_longest(aList):
    longest=0
    for x in range(len(aList)):
        if len(aList[x])>= longest:
            longest=len(aList[x])
            word=aList[x]
    return word
#5
def total_length(aList):
    total=0
    for x in range(len(aList)):
        total+=len(aList[x])
    return total
#6
def zip(aList,bList):
    clist=[]
    for x in range(len(aList)):
        clist.append(aList[x])
        clist.append(bList[x])
    return clist
#7
def unzip(aList):
    bList=[]
    cList=[]
    for x in range(len(aList)):
        if x % 2 == 0:
            bList.append(aList[x])
        else:
            cList.append(aList[x])
    return [bList, cList]
#8
def oddValuesSum(aList):
    total=0
    odd=[]
    for x in range(len(aList)):
        if aList[x] % 2 != 0:
            odd.append(aList[x])
            total += aList[x]
    return total
#9
def oddIndexSum(aList):
    total=0
    for x in range(len(aList)):
        if x%2 != 0:
            total+=aList[x]
    return total
#10
def longStrings(aList):
    bList=[]
    for x in range(len(aList)):
        if len(aList[x]) > 4:
            bList.append(aList[x])
    return bList
#11
def long_N_Strings(aList,Int):
    bList=[]
    for x in range(len(aList)):
        if len(aList[x])>Int:
            bList.append(aList[x])
    return bList
#12
def chooser(aList,bList):
    cList=[]
    for x in range(len(bList)):
        if (bList[x]) == True:
            cList.append(aList[x])
    return cList
#13
def is_member(String,aList):
    for x in range(len(aList)):
        if String == aList[x]:
            return True
    return False    
#14
def intersection(aList,bList):
    cList=[]
    for x in range(len(aList)):
        for i in range(len(bList)):
            if (aList[x]) == (bList[i]):
                duplicate = False
                for word in range(len(cList)):
                    if (aList[x]) == (cList[word]):
                        duplicate = True
                if not duplicate:
                        cList.append(aList[x])
    return cList

#15
def difference(aList,bList):
    cList=[]
    for x in range(len(aList)):
        wordinfirst = False
        for i in range(len(bList)):
            if (aList[x]) == (bList[i]):
                wordinfirst = True
        if not wordinfirst and aList[x] not in cList:
            cList.append(aList[x])
    return cList     
#16
def plusOne(aList):
    for x in range(len(aList)):
        aList[x]+=1
    return None
