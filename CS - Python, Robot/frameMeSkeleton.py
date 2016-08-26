#Your Name
#Your GTID / email address
#Collaboration Statement: ...

"""
Main function. You will need to query the user for their name,
do some calculation to determine the line length, and produce the
properly formatted output
    char - the character to create the frame with
    buff - the buffer on both the left and right side of the name
"""
def frameMe(char, buff):
    #Code for frameMe Goes here



"""
Function to return a single line of characters for a particular length
    length - the length of the line
    char - the character to create the frame with
"""
def createLine(length, char):
    toRet = ""

    #write code to do some manipulation to toRet in order
    #to return the correct line

    return toRet

"""
Function to return a properly formatted and centered name
    name - the name to center
    buff - the buffer on both the left and right side of the name
    char - the character to create the frame with
"""
def centerWord(name, buff, char):
    toRet = ""

    #write code to do some manipulation to toRet in order
    #to return the correctly centered line with proper buffer and characters
    
    return toRet


"""
The following tests (run from the shell) should match with what your function prints

>>> frameMe("^", 5)
Please enter a name: Sam
^^^^^^^^^^^^^
^    Sam    ^
^^^^^^^^^^^^^
>>> 


>>> frameMe("~", 18)
Please enter a name: Cari
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~                 Cari                 ~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
>>> 


>>> frameMe("*", 3)
Please enter a name: Roger Federer
*******************
*  Roger Federer  *
*******************
>>> 
"""
