import csv
#q1

def q1(csvfile):
    aList=[]
    with open(csvfile,'r') as fp:
        reader=csv.reader(fp)
        header=next(reader)
        for row in reader:
            aDict={}
            for i in range(len(header)):
                aDict[header[i]]=row[i]
                aList.append(aDict)
    return aList
#q2

#q3

#q4
