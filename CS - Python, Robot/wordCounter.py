##Name:Stephanie Remy
##GTID:902776472
##GTEmail:sremy3@gatech.edu
##Collaboration Statement: I worked alone using only course materials.


def wordCounter(textfilename):
    a=open(textfilename,"r")
    b=a.readlines()
    paragraphs=0
    count=0
    answer=[]
    a='\n'
    for lines in b:
        for letters in lines:
            if letters in ' ':
                count=count+1
    for lines in b:
        if lines!=a:
            paragraphs=paragraphs+1
    print "The number of words in this file is: ",count+paragraphs
