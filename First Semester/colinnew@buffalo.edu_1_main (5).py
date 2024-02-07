#Part A
def partA(filename,string):
    total=0
    with open(filename,"r") as fp:
        lines=fp.readlines()
        for words in lines:
            for char in words:
                if char == string:
                    total+=1
    return total
#Part B
def partB(string,aList):
    output=string
    with open(output,"w") as op:
        for x in aList:
            op.write(x+'\n')
    return None
#Part C
def partC(filename):
    output=filename+'.rev'
    with open(filename,'r') as fp:
        lines=fp.readlines()
    with open(output,'w') as op:
        reverselines=reversed(lines)
        for line in reverselines:
            final=line.rstrip('\n')
            op.write(final+'\n')
    return None
