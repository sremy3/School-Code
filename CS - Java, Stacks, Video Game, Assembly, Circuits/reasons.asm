;;===============================
;;Name: Stephanie Remy
;;===============================

.orig x3000

AND R0, R0, 0
AND R1, R1, 0
AND R2, R2, 0
AND R3, R3, 0; CLEAR REGISTERS

LD R1, N; PUT N IN R1 
LEA R0, START_MSG_1
PUTS; printf("The ")

LEA R2, GRAMMAR_ARR; GET ADDRESS OF GRAMMAR_ARR
ADD R1, R2, R1; INCREMENT TO ITEM NEEDED
ADD R1, R1, -1; NEED ITEM N-1
LDR R0, R1, 0; GET ITEM FROM ADDRESS
PUTS; printf(grammar_arr[N-1])

LEA R0, START_MSG_2
PUTS; printf(" reasons I love CS 2110 so far:\n")

;SETUP STARTING CONDITIONS FOR LOOP
LD R1, N; PUT N IN R1
AND R2, R2, 0; I = 0

LOOP
;BODY OF LOOP
LEA R3, MESSAGE_ARR; GET ADDRESS OF MESSAGE_ARR
ADD R3, R3, R2; INCREMENT TO ITEM NEEDED
LDR R0, R3, 0; GET ITEM FROM ADDRESS
PUTS; printf(MESSAGE_ARR[I])
ADD R2, R2, 1; I++

;CONDITION FOR LOOP
NOT R3, R2
ADD R3, R3, 1
ADD R3, R3, R1; I < N
BRp LOOP; LOOP IF I < N

HALT


N .fill 1

START_MSG_1
    .stringz "The "

START_MSG_2
    .stringz " reasons I love CS 2110 so far:\n"

GRAMMAR_ARR
    .fill GRAM01
    .fill GRAM02
    .fill GRAM03
    .fill GRAM04
    .fill GRAM05
    .fill GRAM06
    .fill GRAM07
    .fill GRAM08
    .fill GRAM09
    .fill GRAM10

MESSAGE_ARR
    .fill MESS01
    .fill MESS02
    .fill MESS03
    .fill MESS04
    .fill MESS05
    .fill MESS06
    .fill MESS07
    .fill MESS08
    .fill MESS09
    .fill MESS10
.end

.orig x5000
GRAM01
    .stringz "one"
GRAM02
    .stringz "two"
GRAM03
    .stringz "three"
GRAM04
    .stringz "four"
GRAM05
    .stringz "five"
GRAM06
    .stringz "six"
GRAM07
    .stringz "seven"
GRAM08
    .stringz "eight"
GRAM09
    .stringz "nine"
GRAM10
    .stringz "ten"
MESS01
    .stringz "One, I made this cool program in assembly!\n"
MESS02
    .stringz "Two, the TAs are super helpful!\n"
MESS03
    .stringz "Three, Professor Leahy is an entertaining lecturer!\n"
MESS04
    .stringz "Four, I now know how to prevent electrical fires!\n"
MESS05
    .stringz "Five, bitwise operations are really useful!\n"
MESS06
    .stringz "Six, I can make state machines now!\n"
MESS07
    .stringz "Seven, memory is no longer a mystery!\n"
MESS08
    .stringz "Eight, I understand how a basic computer works now!\n"
MESS09
    .stringz "Nine, I feel more confident with binary and hex!\n"
MESS10
    .stringz "Ten, I'm looking forward to learning C!\n"
.end
