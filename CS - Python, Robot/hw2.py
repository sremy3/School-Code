#Stephanie Remy/Sydney Halinski
#902776472/902600435
#Sremy3@gatech.edu/Shalinski3@gatech.edu
#We worked on this assignment with each other using this semester's course material.



def mass(pounds):
    print (1.0*pounds)/256

def volume(liters):
    gallons=(1.0*liters)*.264
    print "There are %.2f US gallons in %.2f liters" % (gallons, liters)


def bears(polar, integer):
    soda=(polar)*1151.430565248
    n=int(integer)
    print ("There are %."+str(n)+"f cans of soda in %."+str(n)+"f male polar bears.") % (soda, polar)

 
def calcEnergy(time,kwh,ppkw,discount):
    total=(time*kwh*ppkw)
    if discount==True:
        return total-(total*.2)
    else:
        return total
def makeSandwiches(bread,peanutbutter,jelly):
    a=bread%2
    b=(bread-a)/2
    c=peanutbutter%1.5
    d=(peanutbutter-c)/1.5
    e=jelly%.5
    f=(jelly-e)/.5
    g=int(min(b,d,f))
    return g
    
