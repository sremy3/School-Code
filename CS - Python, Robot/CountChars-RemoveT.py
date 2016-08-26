##Name: Stephanie Remy
##GTID: 902776472
##Email: sremy3@gatech.edu
##Collaboration Statement: I did this assignment along and refered to http://ubuntuforums.org/showthread.php?t=796686.



def countChars(string):
    count=0
    for characters in string:
        if characters in "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!'.?1234567890":
            count=count+1
    return count




def removeT(booleanstatement):
    z='quit'
    if booleanstatement==False:
        answer=[]
        a=raw_input("Please enter a word/sentence you want to process: ")
        while a!=z:
            for letters in a:
                if letters in 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!. ':
                    answer.append(letters)
            z='quit'
            a=raw_input("Please enter a word/sentence you want to process: ")
        try:
            answer[answer.index('T')] = ' '
            answer.reverse()
            b=reduce(lambda x, y:y+x,answer)
            return b
        except:
            return
    if booleanstatement==True:
        answer=[]
        a=raw_input("Please enter a word/sentence you want to process: ")
        while a!=z:
            for letters in a:
                if letters in 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!. ':
                    answer.append(letters)
            z='quit'
            a=raw_input("Please enter a word/sentence you want to process: ")
        try:
            answer[answer.index('T')] = ' '
            answer[answer.index('t')] = ' '
            answer.reverse()
            b=reduce(lambda x, y: y+x, answer)
            return b
        except:
            return
