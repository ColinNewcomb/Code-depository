#Part A
def partA(ounces):
    grams=(ounces)*28.35
    c=round(grams,2)
    return c
#Part B
def partB(pounds,ounces):
    tounces=(pounds*16)+ounces
    return tounces
#Part C
def partC(pounds,ounces):
    tounce=partB(pounds,ounces)
    grams=partA(tounce)
    c=grams/1000
    d=round(c,4)
    return d

print(partA(0.0))
print(partA(1.0))
print(partA(1.5))

print(partB(0,0))
print(partB(1,1))
print(partB(2,3))

print(partC(0,0))
print(partC(1,1))
print(partC(2,3))
