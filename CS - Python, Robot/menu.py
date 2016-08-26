##Name: Stephanie Remy
##GTID:902776472
##Email:sremy3@gatech.edu
##Collaboration Statement: I worked alone and only used the course materials.


from myro import *
##
##initialize("El_Rayo")
##
def menu():
    print "1. The Charleston"
    print "2. The Tango"
    print "3. The Foxtrot"
    print "0. Exit"
    a=raw_input("Which dance step would you like? ")
    b="1"
    c="2"
    d="3"
    e="0"
    if a==b or a==c or a==d or a==e:
        while a==b or a==c or a==d:
            if a==b:
                beep(.7,400)
                wait(.3)
                beep(.7,400)
                wait(.3)
                beep(.7,400)
                beep(.7,400)
                wait(.3)
                beep(.7,600)
                beep(.3,400,500)
                beep(.3,600)
                beep(.3,400,500)
                beep(.3,600)
                beep(.3,600)
                beep(.3,600)
                beep(.3,600)
                beep(.3,400,500)
                translate(1)
                move(0,-1)
                move(0,1)
                translate(-1)
                move(0,-1)
                move(0,1)
                translate(1)
                move(0,-1)
                move(0,1)
                translate(-1)
                move(0,-1)
                move(0,1)
                beep(.7,600)
                beep(.3,400,500)
                beep(.3,600)
                beep(.3,400,500)
                beep(.3,600)
                beep(.3,600)
                beep(.3,600)
                beep(.3,600)
                beep(.3,400,500)
                stop()
                print "1. The Charleston"
                print "2. The Tango"
                print "3. The Foxtrot"
                print "0. Exit"
                a=raw_input("Which dance step would you like? ")
            elif a==c:
                beep(.2,300)
                beep(.2,200)
                beep(.2,400)
                turnRight(1,.7)
                translate(1)
                beep(.3,450)
                beep(.5,450)
                beep(.3,400)
                beep(.3,300)
                beep(.3,200)
                move(0,-1)
                beep(.3,450)
                beep(.3,450)
                stop()
                translate(1)
                beep(.3,450)
                beep(.5,450)
                beep(.3,400)
                beep(.3,300)
                beep(.3,200)
                stop()
                turnRight(1,.7)
                translate(1)
                beep(.3,450)
                beep(.5,450)
                beep(.3,400)
                beep(.3,300)
                beep(.3,200)
                move(0,-1)
                beep(.3,450)
                beep(.3,450)
                stop()
                translate(1)
                beep(.3,450)
                beep(.5,450)
                beep(.3,400)
                beep(.3,300)
                beep(.3,200)
                stop()
                print "1. The Charleston"
                print "2. The Tango"
                print "3. The Foxtrot"
                print "0. Exit"
                a=raw_input("Which dance step would you like? ")
            elif a==d:
                beep(.4,200,250)
                beep(.4,350)
                beep(.4,200,250)
                beep(.4,350)
                beep(.4,200,250)
                beep(.4,350)
                beep(.4,400)
                beep(.3,400)
                beep(.3,450)
                translate(1)
                stop()
                move(0,.2)
                stop()
                translate(1)
                stop()
                move(0,.2)
                stop()
                translate(1)
                beep(.4,200,250)
                beep(.4,350)
                beep(.4,200,250)
                beep(.4,350)
                beep(.4,200,250)
                beep(.4,350)
                beep(.4,400)
                beep(.3,400)
                beep(.3,450)
                translate(-1)
                stop()
                move(0,.2)
                stop()
                translate(-1)
                stop()
                move(0,.2)
                stop()
                translate(-1)
                beep(.4,200,250)
                beep(.4,350)
                beep(.4,200,250)
                beep(.4,350)
                beep(.4,200,250)
                beep(.4,350)
                beep(.4,400)
                beep(.3,400)
                beep(.3,450)
                stop()
                print "1. The Charleston"
                print "2. The Tango"
                print "3. The Foxtrot"
                print "0. Exit"
                a=raw_input("Which dance step would you like? ")
        if a==e:
            print "Have a good day!"
        else:
            print
            print "I'm sorry, I don't know that one."
            menu()
    else:
        print
        print "I'm sorry, I don't know that one."
        menu()
