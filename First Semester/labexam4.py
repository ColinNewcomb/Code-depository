import csv
#Part A
def partA(filename):
    aList=[]
    with open(filename,"r") as fp:
        reader=csv.reader(fp)
        headers=next(reader)
        for x in headers:
            aList.append(x)
    return aList

#Part B
def partB(filename,data):
    adict={}
    for i in data:
        key=i[0]
        value=i[1]
        adict[key]=adict.get(key,0)+value
    with open(filename,'w',newline='') as fp:
        writer=csv.writer(fp)
        for key, value in adict.items():
            writer.writerow([key,value])

data=[['a',3],['b',2],['a',7],['c',8],['a',6]]

partB("file.csv",data)

#Part C
def partC(inputcsv,outputcsv,dictionary):
    with open(inputcsv,'r') as ip:
        with open(outputcsv,'w') as op:
            reader=csv.reader(ip)
            writer=csv.writer(op)
            for row in reader:
                secondrow=row[2]
                if secondrow in dictionary:
                    row.append(dictionary[secondrow])
                else:
                    row.append("***")
                writer.writerow(row)

