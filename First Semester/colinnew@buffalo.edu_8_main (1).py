import csv
#Part A
def partA(filename):
    aList=[]
    with open(filename,'r') as fp:
        reader=csv.reader(fp)
        header=next(reader)
        for x in header:
            aList.append(x)
    return aList
#Part B
def partB(filename,lists):
    adict={}
    with open(filename,'w',newline='') as fp:
        for i in lists:
            key=i[0]
            value=i[1]
            adict[key]=adict.get(key,0)+value
        for key in adict:
            writer=csv.writer(fp)
            writer.writerow([key,adict[key]])

data = [ ['a',3], ['b',2], ['a',7], ['c',8], ['a',6] ]
partB('file.csv',data)
                
#Part C
def partC(inputfile,outputfile,dictionary):
    with open(inputfile,'r') as fp:
        with open(outputfile,'w',newline='') as op:
            reader=csv.reader(fp)
            writer=csv.writer(op)
            for row in reader:
                second=row[2]
                if second in dictionary:
                    row.append(dictionary[second])
                    writer.writerow(row)
                else:
                    row.append("***")
                    writer.writerow(row)
