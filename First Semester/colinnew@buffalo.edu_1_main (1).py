#Part A
aList=[]
def how_many_single_digit_numbers(aList):
    num=0
    for x in range(len(aList)):
        if aList[x]<=9 and aList[x]>=-9:
            num+=1
    return num
print(how_many_single_digit_numbers([]))
print(how_many_single_digit_numbers([3,7,12,-2]))
print(how_many_single_digit_numbers([-10,10]))
#Part B
bList=[]
def sum_of_single_digit_numbers(bList):
    num=0
    for x in range(len(bList)):
        if bList[x]<=9 and bList[x]>=-9:
            num+=bList[x]
    return num
print(sum_of_single_digit_numbers([]))
print(sum_of_single_digit_numbers([3,7,12,-2]))
print(sum_of_single_digit_numbers([-10,10]))

#Part C

def squares(cList):
    dList=[]
    for x in range(len(cList)):
        something=cList[x]**2
        dList.append(something)
    return dList

print(squares([]))
print(squares([3.0,1.0,-2.5,0.0]))
