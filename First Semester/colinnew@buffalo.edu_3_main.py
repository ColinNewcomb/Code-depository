import math
#Number 1
def r_perimeter(length,width):
    rperimeter=(length+width)*2
    return rperimeter

#Number 2
def r_area(length,width):
    rarea=length*width
    return rarea

#Number 3
def c_perimeter_radius(radius):
    pcircum=2*(math.pi)*radius
    return pcircum

#Number 4
def c_perimeter_diameter(diameter):
    dcircum=math.pi*diameter
    return dcircum

#Number 5
def c_area_radius(radius):
    area=math.pi*(radius**2)
    return area

#Number 6
def c_area_diameter(diameter):
    area=(math.pi/4)*(diameter**2)
    return area

#Number 7
def how_much_paint(width,height,paint):
    gallons=(height*width)/paint
    return gallons

#Number 8 
def how_many_paint_cans(width,height,paint):
    gallon=width*height/paint
    cans=math.ceil(gallon)
    return cans





