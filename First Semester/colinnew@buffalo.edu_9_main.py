#Part A
def countAlpha(afile):
    count=0
    with open(afile,"r") as fp:
        for line in fp:
            for char in line:
                abool=char.isalpha()
                if abool is True:
                    count+=1
    return count
#Part B
def readAddressBook(afile):
    aDict={}
    with open(afile,"r") as fp:
        for lines in fp:
            something=lines.rstrip("\n")
            strings=something.split(":")
            aDict[strings[0]]=(strings[1])
    return aDict

#Part C
def writeAddressBook(outputfile,aDict):
    with open(outputfile,"w") as op:
        for key in aDict.keys():           
            op.write(str(key)+":"+str(aDict[key])+"\n")
    return None
dictionary={'ww8': 2648757, 'XOjW': 6192233}
print(writeAddressBook('writefile.txt',dictionary))

