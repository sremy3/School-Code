##Name:Stephanie Remy
##GTID:902776472
##GTEmail:sremy3@gatech.edu
##Collaboration Statement: We[Stephanie Remy, Maryann Remy, and John Lambert] worked alone using only course materials.

from myro import *
init()



#lens-flare-20pts
def lens_flare():
    picture=takePicture()
    x_range=range(0,256)
    y_range=range(0,192)
    W=getWidth(picture)
    H=getHeight(picture)
    for i in x_range:
        for j in y_range:
            if (((i-176)**2)+((j-48)**2))<450:
                pixel = getPixel(picture, i, j)
                color=getColor(pixel)
                a=makeLighter(pixel)
            if (((i-50)**2)+((j-150)**2))<450:
                pixel = getPixel(picture, i, j)
                color=getColor(pixel)
                a=makeLighter(pixel)
            if (((i-130)**2)+((j-170)**2))<450:
                pixel = getPixel(picture, i, j)
                color=getColor(pixel)
                a=makeLighter(pixel)
    show(picture)


#split-screen-50pts
def split_screen():
    one=takePicture()
    turnLeft(2,.5)
    two=takePicture()
    turnLeft(2,.5)
    three=takePicture()
    turnLeft(2,.5) 
    four=takePicture()
    turnLeft(2,.5)
    five=takePicture()
    turnLeft(2,.5)
    final=[one,two,three,four,five]
    e=takePicture()
    turnLeft(2,.5)
    d=takePicture()
    turnLeft(2,.5)
    c=takePicture()
    forward(2,.5)
    b=takePicture()
    forward(2,.5)
    a=takePicture()
    turnLeft(2,.5)
    final3=[e,d,c,b,a]
    result=[]
    count=0
    while count!=5:
        newPicture = makePicture(512, 192)
        for picture in final:
            for x in range(256):
                for y in range(192):
                        setColor(getPixel(newPicture, x, y), getColor(getPixel(picture, x, y)))
                        print "working on first half" #marker
        for pic in final3:
            for sun in range(256):
                for moon in range(192):
                        setColor(getPixel(newPicture, (sun+256), moon), getColor(getPixel(pic, sun, moon)))
                        print "working on second half" #marker
        result.append(newPicture)
        count=count+1
        print count #marker
        show(newPicture)
    savePicture(result,"split_screen.gif")


#Fade-35pts
def fade():
    from myro import *
    picture=takePicture()
    black=makeColor(0,0,0)
    show(picture)
    for i in range(10):
        for pix in getPixels(picture):
            makeDarker(pix)
        show(picture)
        wait(.05)


#Screen-Shake-45pts
def screen_shake():
    from myro import *
    import random as rnd
    picture=takePicture()
    win=GraphWin()
    for i in range(20):
        image = Image(Point(rnd.uniform(-10,10), rnd.uniform(-10,10)), makePixmap(picture))
        image.draw(win)
        image.move(10,10)
        image.refresh(win)


#MakeYourOwn-?pts
def drawCrosshair():
    #overlays a crosshair on top of a picture taken by the robot
    picture = takePicture()
    for yPos in range(0, getHeight(picture) ):
        aPixel = getPixel(picture, (getWidth(picture)/2), yPos)
        setRed(aPixel,255)
        setGreen(aPixel,255)
        setBlue(aPixel,255)

    for xPos in range(0, getWidth(picture)):
        bPixel = getPixel(picture, xPos, (getHeight(picture)/2))
        setRed(bPixel,255)
        setGreen(bPixel,255)
        setBlue(bPixel,255)
        
    savePicture(picture, "crosshair.gif")


#SeeingRed-15pts
def seeingRed():
    #adds a reddish tint to a picture taken by the robot
    p = takePicture()
    for pixel in getPixels(p):
        r,g,b = getRGB(pixel)
        setRed(pixel, 200)
    show(p)


#360view-15pts
def pic360():
    #robot takes a picture, saves picture to a list, rotates, repeats
    pictureList = []  
    for i in range(16):
        pic = takePicture()
        pictureList = pictureList + [pic]
        turnRight(0.4,0.1)

    savePicture(pictureList,"360view.gif")


#RobotZoom-15pts
def robotZoom():
    #robot takes a picture, saves it to a list, moves forward, repears
    pictureList = []
    for i in range(30):
        pic = takePicture()
        pictureList = pictureList + [pic]
        forward(0.3,0.1)
        
    savePicture(pictureList, "robotZoom.gif")


#MakeYourOwn-?pts
def ncis():
    #Robot takes a picture, converts that picture from color into grayscale
    # function is called NCIS after the show's use of grayscale stills before commercial break
    #Given its similarity to seeingRed, ought to be worth around 15 points
    p = takePicture()
    for pixel in getPixels(p):
        r = getRed(pixel)
        g = getGreen(pixel)
        b = getBlue(pixel)
        avg = (r + g + b) / 3
        color = makeColor(avg, avg, avg)
        setColor(pixel, color)
    show(p)


#MakeYourOwn-?pts
def negative():
    #robot takes a picture, converts RGB values to produce a negative effect
    #given its similarity to seeingRed, ought to be worth around 15 points
    p = takePicture() 
    for pixel in getPixels(p):
        r = getRed(pixel)
        g = getGreen(pixel)
        b = getBlue(pixel)
        color = makeColor(255 - r, 255 - g, 255 - b)
        setColor(pixel, color)
    show(p)
