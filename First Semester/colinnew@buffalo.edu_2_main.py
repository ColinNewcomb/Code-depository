import math
#Part A
def abv_simple(pre,post):
    abv=(pre-post)*131.25
    b=round(abv,2)
    return b

print(abv_simple(1.050,1.010))
print(abv_simple(1.055,1.015))
print(abv_simple(1.045,1.008))

def abv_precise(pre,post):
    abv=(76.08*(pre-post)/(1.775-pre))*(post/0.794)
    b=round(abv,2)
    return b

print(abv_precise(1.050,1.010))
print(abv_precise(1.055,1.015))
print(abv_precise(1.045,1.008))

#PartB
def canadianize(str_val):
    out=str_val.replace("er ","re ")
    out=out.replace("or","our")
    return out
                    
print(canadianize("Theater is colorful."))
print(canadianize("Labor honors more color in the theater."))
print(canadianize("Food with fiber can be flavorful if eaten under the arbor."))
print(canadianize("hoer zooer pooer goer doer"))

#Part C
def absolute_difference(pre,post):
    a=abs(abv_simple(pre,post)-abv_precise(pre,post))
    b=round(a,2)
    return b

print(absolute_difference(1.050,1.01))
print(absolute_difference(1.055,1.015))
print(absolute_difference(1.045,1.008))    
