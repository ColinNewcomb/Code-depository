import csv
#Part A
def listNegative(afile):
    aList=[]
    with open(afile,"r") as fp:
        reader=csv.reader(fp)
        for row in reader:
            lastvalue=int(row[-1])
            if lastvalue < 0:
                aList.append(row)
    return aList
#Part B
def writecsv(aList,outputfile):
    with open(outputfile,"w") as op:
        writer=csv.writer(op)
        for x in range(len(aList)):
            writer.writerow(aList[x])
    return None
#Part C
def reverseFields(afile):
    aList=[]
    with open(afile,'r') as f:
        reader=csv.reader(f)
        for row in reader:
            aList.append(row)
    with open(afile,'w') as f:
        writer=csv.writer(f)
        for x in range(len(aList)):
            reverse=reversed(aList[x])
            writer.writerow(reverse)
    return None
