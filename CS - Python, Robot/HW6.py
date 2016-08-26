#Stephanie Remy
#GTID:902776472
#email:sremy3@gatech.edu
#collaboration statement: We[my partner and I] worked alone on this assignment using only course material.


from myro import *
init()
       

def yellow_Wall():
    turnSpeed = .5
    speed = 0.5
    while timeRemaining(120):
        L,R = getIR()
        right = 1 - R
        left = 1 - L

        #Check for wall in front of us
        if right and left:
            turnLeft(turnSpeed,1.3)
            pic = takePicture()
            blue = 0
            green = 0
            red = 0
            count = 0
            for pix in getPixels(pic):
                r,g,b = getRGB(pix)
                count = count + 1
                red = red + r
                green = green + g
                blue = blue + b
            RED = red/float(count)
            GREEN = green/float(count)
            BLUE = blue/float(count)
            print "In front"
            print RED,GREEN,BLUE

            while sum(getObstacle()) < 3000:
                forward(.5,.5)

            #If Blue
            #go to yellow
            if BLUE > RED and BLUE > GREEN and (BLUE-RED)>=100:
                print "It's BLUE!"
                turnRight(.3,.5)
                backward(speed)

            #If Green
            #go to yellow
            elif RED < 200 and GREEN < 200 and BLUE < 200:
                print "It's GREEN!"
                turnLeft(.3,.5)
                backward(speed)
                
            #If yellow
            #celebrate
            elif RED > BLUE and GREEN > BLUE and BLUE <= 150:
                print "It's YELLOW!"
                
                stop()
                beep(3,500)
                rotate(.5)
                beep(3,700,800)
                rotate(-1)
                stop()
                return

            #white
            else:
                print "It's WHITE!"
                pass
            
            #Avoid walls
            if right and left:
                turnLeft(turnSpeed,.5)
            elif left:
                move(-speed,-turnSpeed)
            elif right:
                move(-speed,turnSpeed)
            else:
                backward(speed)
                
        #check for color 
        elif left:
            turnRight(turnSpeed,1.5)
            pic = takePicture()
            blue = 0
            green = 0
            red = 0
            count = 0
            for pix in getPixels(pic):
                
                r,g,b = getRGB(pix)
                count = count + 1
                red = red + r
                green = green + g
                blue = blue + b
            RED = red/float(count)
            GREEN = green/float(count)
            BLUE = blue/float(count)
            
            print "On left"
            print RED,GREEN,BLUE

            while sum(getObstacle()) < 3000:
                forward(.5,.5)

            #If Blue
            #go to yellow
            if BLUE > RED and BLUE > GREEN and (BLUE-RED)>=100:
                print "It's BLUE!"
                turnRight(.3,.5)
                backward(speed)

            #If Green
            #go to yellow
            elif RED < 200 and GREEN < 200 and BLUE < 200:
                print "It's GREEN!"
                turnLeft(.3,.5)
                backward(speed)
                
            #If yellow
            #celebrate
            elif RED > BLUE and GREEN > BLUE and BLUE <= 150:
                print "It's YELLOW!"
                
                stop()
                beep(3,500)
                rotate(.5)
                beep(3,700,800)
                rotate(-1)
                stop()
                return

            #white
            else:
                print "It's WHITE!"
                pass
                
            #Avoid walls
            if right and left:
                turnLeft(turnSpeed,.5)
            elif left:
                move(-speed,-turnSpeed)
            elif right:
                move(-speed,turnSpeed)
            else:
                backward(speed)
                
        #check for color
        elif right:
            turnLeft(turnSpeed,1.5)
            pic = takePicture()
            blue = 0
            green = 0
            red = 0
            count = 0
            for pix in getPixels(pic):
                r,g,b = getRGB(pix)
                count = count + 1
                red = red + r
                green = green + g
                blue = blue + b
            RED = red/float(count)
            GREEN = green/float(count)
            BLUE = blue/float(count)
            print "On right"
            print RED,GREEN,BLUE

            while sum(getObstacle()) < 3000:
                forward(.5,.5)

            #If Blue
            #go to yellow
            if BLUE > RED and BLUE > GREEN and (BLUE-RED)>=100:
                print "It's BLUE!"
                turnRight(.3,.5)
                backward(speed)

            #If Green
            #go to yellow
            elif RED < 200 and GREEN < 200 and BLUE < 200:
                print "It's GREEN!"
                turnLeft(.3,.5)
                backward(speed)
                
            #If yellow
            #celebrate
            elif RED > BLUE and GREEN > BLUE and BLUE <= 150:
                print "It's YELLOW!"
                
                stop()
                beep(3,500)
                rotate(.5)
                beep(3,700,800)
                rotate(-1)
                stop()
                return

            #white
            else:
                print "It's WHITE!"
                pass
            #Avoid walls
            if right and left:
                turnLeft(turnSpeed,.5)
            elif left:
                move(-speed,-turnSpeed)
            elif right:
                move(-speed,turnSpeed)
            else:
                backward(speed)

        else:
            print "Can't detect"
            backward(speed)

