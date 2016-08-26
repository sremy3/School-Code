#Name: Stephanie Remyf
#CS 1301-A5
#GTID: 902776472
#email: sremy3@gatech.edu
#Collaboration Statement: I worked on this assignment alone and referred to http://docs.python.org/library/fpformat.html and http://docs.python.org/library/functions.html#reduce.

def checkHeight(height):
    if height>=132:
        return "Have a great ride!"
    else:
        return "Sorry. You must be at least 1 meter 32 cm to ride."


import fpformat
def smallestAndLargest(num1,num2,num3):
    if num1>=num2>=num3:
        return ("Smallest Number: "+str(fpformat.fix(num3,6))+ "; Largest Number: "+str(fpformat.fix(num1,6)))
    elif num2>=num3>=num1:
        return ("Smallest Number: "+str(fpformat.fix(num1,6)) + "; Largest Number: "+str(fpformat.fix(num2,6)))
    elif num3>=num1>=num2:
        return ("Smallest Number: "+str(fpformat.fix(num2,6))+"; Largest Number: "+str(fpformat.fix(num3,6)))
    elif num3>=num2>=num1:
        return ("Smallest Number: "+str(fpformat.fix(num1,6))+ "; Largest Number: "+str(fpformat.fix(num3,6)))
    elif num2>=num1>=num3:
        return ("Smallest Number: "+str(fpformat.fix(num3,6))+ "; Largest Number: "+str(fpformat.fix(num2,6)))
    elif num1>=num3>=num2:
        return ("Smallest Number: "+str(fpformat.fix(num2,6))+ "; Largest Number: "+str(fpformat.fix(num1,6)))


def countDownByTwos(start):
    while start> 0:
        print start
        start=start-2
    print "Blast Off!"


def multiplicationTables(number,limit):
    m=0
    while m<=limit:
        n=number*m
        print str(number)+"*"+str(m)+" = "+str(n)
        m=m+1


def complimentMaker(answer1,answer2,answer3,answer4):
    answer=[]
    if answer1==True or answer2==True or answer3==True or answer4==True:
        answer.append("You are ")
        if answer1==True:
            answer.append("super ")
        if answer2==True:
            answer.append("nice ")
        if answer3==True:
            answer.append("smart")
        if answer4==True:
            answer.append(" cool.")
        if answer4==False:
            answer.append(".")
        answer.reverse()
        a=reduce(lambda x, y: y+x, answer)
        return a
    if answer1==False or answer2==False or answer3==False or answer4==False:
        return "No Comment."


def comboLock(num1,num2,num3,num4,num5):
    if num1%2==0 and num2%2==0 and num3%2==1 and num4%2==0 and num5%2==1 and num1<10 and num2<10 and num3<10 and num4<10 and num5<10:
            return "You opened the lock."
    else:
        return "You are locked out."


def badRecord(sentence):
    result=[]
    for letters in sentence:
        if letters in'ABCDEFGHHIJKLMNOPQRSTUVWXYZ':
            result.insert(0,letters)
    result.reverse()
    a=reduce(lambda x, y: x+y, result)
    return a


def printTimestable():
    print "Times: ",
    d=1
    while d<=9:
        print d,'\t',
        d=d+1
    print
    a=1
    b=1
    def x(a,b):
        while b<=9:
            c=a*b
            print c,'\t',
            b=b+1
            continue
    while a<=9:
        print a,'\t',
        x(a,b)
        print
        a=a+1   


def printTimes(N):
    print "Times: ",
    d=1
    while d<=N:
        print d,'\t',
        d=d+1
    print
    a=1
    b=1
    def x(a,b):
        while b<=N:
            c=a*b
            print c,'\t',
            b=b+1
            continue
    while a<=N:
        print a,'\t',
        x(a,b)
        print
        a=a+1
