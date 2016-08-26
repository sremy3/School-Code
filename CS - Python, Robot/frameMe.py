#Stephanie Remy
#GTID:902776472 / email address:sremy3@gatech.edu
#Collaboration Statement:We (Sydney and Stephanie) worked on this homework using this semester's course materials.

def frameMe(char,buff):
    name=raw_input("What is your name? ")
    length_of_name=len(name)
    length_of_line=length_of_name+(2*buff)
    print createLine(length_of_line,char)
    print centerWord(name,buff,char)
    print createLine(length_of_line,char)

def createLine(length_of_line,char):
    toRet=char*length_of_line
    return toRet

def centerWord(name,buff,char):
    spacing= (buff-1) * " "
    toRet = char+spacing+name+spacing+char
    return toRet
