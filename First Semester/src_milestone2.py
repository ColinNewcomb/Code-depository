import csv
def convertToDictionaries(keys,values):
    aList=[]
    for value in values:
        dictionary={}
        for x in range(len(keys)):
            dictionary[keys[x]]=value[x]
        aList.append(dictionary)
    return aList


def loadRecords(filename):
    aList=[]
    with open(filename) as fp:
        reader=csv.reader(fp)
        headers=next(reader)
        for rows in reader:
            bList=[]
            for x in range(min(len(rows),len(headers))):
                bList.append(rows[x])
            aList.append(bList)
    return aList
        
def convertToLists(keys,lod):
    aList=[]
    for dict in lod:
        bList=[]
        for key in keys:
            if key in dict:
                bList.append(dict[key])
            else:
                bList.append("")
        aList.append(bList)
    return aList

def writeRecords(filename,records):
    with open(filename,'a',newline='') as fp:
        writer= csv.writer(fp)
        writer.writerows(records)
    return None

