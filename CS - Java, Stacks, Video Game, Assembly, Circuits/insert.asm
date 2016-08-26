;;===============================
;;Name: Stephanie Remy
;;===============================

.orig x3000

AND R0, R0, 0
AND R1, R1, 0
AND R2, R2, 0
AND R3, R3, 0
AND R4, R4, 0
AND R5, R5, 0
AND R6, R6, 0
AND R7, R7, 0
;CLEAR OUT ALL REGISTERS

;FOR(INT K = 1; K < LENGTH;...)
ADD R0, R0, 1; k = 1
LD R1, LENGTH
NOT R1, R1
ADD R1, R1, 1
ADD R2, R0, R1; k < LENGTH
BRzp SKIPLOOP; if k >= LENGTH, SKIPLOOP

LOOP

;BODY OF OUTTER FOR LOOP
LD R3, ARRAY; Start of ARRAY
ADD R3, R0, R3
LDR R3, R3,0; CURR = ARRAY[K]


;Set Up Conditions for Inner Loop
ADD R7, R0, 0; J = K
BRnz JUMPLOOP
LD R1, ARRAY;Start of ARRAY
ADD R5, R7, -1; J-1
ADD R1, R1, R5; get address of object
LDR R1, R1, 0; array[j-1]
NOT R6,R3
ADD R6, R6, 1
ADD R6, R1, R6; condition for while loop
BRnz JUMPLOOP

INNERLOOP

;INNERLOOP
LD R4, ARRAY
ADD R4, R4, R7; get address of j in array
STR R1, R4, 0; array[j] =array[j - 1]
ADD R7, R7, -1

;check loop conditions again
BRnz JUMPLOOP
LD R1, ARRAY;Start of ARRAY
ADD R5, R7, -1; J-1
ADD R1, R1, R5; get address of object
LDR R1, R1, 0; array[j-1]
NOT R6,R3
ADD R6, R6, 1
ADD R6, R1, R6; condition for while loop
BRp INNERLOOP

JUMPLOOP
LD R1, ARRAY; Start of ARRAY
ADD R1, R7, R1; address of j in array
STR R3, R1,0; array[j] = curr

;INCREMENTER AND CHECK for outter for loop
ADD R0, R0, 1; k = k + 1
LD R1, LENGTH
NOT R1, R1
ADD R1, R1, 1
ADD R2, R0, R1; k < LENGTH
BRn LOOP

;SKIP FOR LOOP IF EMPTY LIST
SKIPLOOP
HALT
ARRAY   .fill x303F
LENGTH  .fill 10
.end

.orig x303F
.fill 100
.fill 10
.fill 0
.fill -10
.fill -100
.fill -101
.fill 102
.fill 106
.fill 103
.fill 108
.end

