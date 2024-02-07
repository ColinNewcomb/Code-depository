#Problem 9
def q9(inputfile,outputfile):
    word_count={}
    with open(inputfile,"r") as ipf:
        for line in ipf:
            words=line.split()
            for word in words:
                if word in word_count:
                    word_count[word]+=1
                else:
                    word_count[word]=1
    sorted_words=sorted(word_count.items(),key=lambda item: item[1], reverse=True)
    top_words=sorted_words[:10]
    with open(outputfile,"w") as op:
        for word,count in top_words:
            op.write(word+"\n")
    return None
#Problem 10
def q10(inputfile1,inputfile2):
    output=inputfile1 + inputfile2
    with open(inputfile1,"r") as ip1:
        lines1=ip1.readlines()
    with open(inputfile2,"r") as ip2:
        lines2=ip2.readlines()
    maxlength=max(len(lines1),len(lines2))
    with open(output,"w") as op:
        for x in range(maxlength):
            if x < len(lines1):
                op.write(lines1[x])
            else:
                op.write("\n")
            if x < len(lines2):
                op.write(lines2[x])
            else:
                op.write("\n")
    return None
#Problem 11
def q11(filename,num):
    base, extension = filename.rsplit(".",1)
    with open(filename,"r") as fp:
        lines=fp.readlines()
    for x in range(num):
        output=f"{base}{x+1}.{extension}"
        with open(output,"w") as op:
            for i in range(x,len(lines),num):
                op.write(lines[i])
    return None
#Problem 12
def q12(filename):
    base, extension = filename.rsplit(".",1)
    vowels="aeiouyAEIOUY"
    consonants="BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz"
    with open(filename,"r") as fp:
        lines=fp.read()
    with open(f"{base}.vowels.{extension}","w") as bve:
        with open(f"{base}.consonants.{extension}","w") as bce:
            with open(f"{base}.others.{extension}","w") as boe:
                for char in lines:
                    if char in vowels:
                        bve.write(char)
                    elif char in consonants:
                        bce.write(char)
                    else:
                        boe.write(char)
    return None


    
