##Name: Stephanie Remy
##GTID: 902776472
##Email:sremy3@gatech.edu
##Collaboration Statement: Stephanie Remy and Abimbola Olajubutu worked alone using only course materials.

def intList(textfile):
    work=open(textfile,"r")
    line1=work.read()
    answer=[]
    for letters in line1:
        if letters in "0123456789":
            answer.append(int(letters))
    work.close()
    print answer
def prefixSum(aList):
    newList=[]
    count=0
    for items in aList:
        newList.append((items+count))
        count=count+items
    return (aList,newList)
        
