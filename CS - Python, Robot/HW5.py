##Name: Stephanie Remy
##GTID: 902776472
##Email:sremy3@gatech.edu
##Collaboration Statement: Abimbola Olajubutu and Stephanie Remy worked alone using only course materials.

from myro import *
init()


def avoidWalls():
    turnSpeed= .5
    speed=.3
    while timeRemaining(60):
        L, R=getIR()
        left=1-L
        right=1-R
        if left and right:
            turnLeft(turnSpeed)
        elif left:
            move(-speed, -turnSpeed)
        elif right:
            move(-speed, turnSpeed)
        else:
            backward(speed)
    stop()
    beep(3,500)
    rotate(.5)
    beep(3,700,800)
    rotate(-1)
    stop()


def seekLight():
    speed=.5
    while timeRemaining(60):
        L,C,R=getLight()
        a=min(L,C,R)
        if a==C and a==L and a==R:
            move(-speed,0)
        elif a==L and a==R:
            move(-speed,0)
        elif a==C:
            move(-speed,0)
        elif a==R:
            move(-speed,-speed)
        elif a==L:
            move(-speed,speed)
            
    stop()
    beep(3,500)
    rotate(.5)
    beep(3,700,800)
    rotate(-1)
    stop()
