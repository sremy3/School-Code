;;===============================

;;Name: STEPHANIE REMY

;;===============================


.orig x3000

	
LD R6, STACK; load the stack pointer

	
AND R0, R0, 0
	
ADD R6, R6, -1; push argument idx=0 on stack
	
STR R0, R6, 0 

	
LD R0, ARRAY3; R0 = ARRAY1, change later to ARRAY2 and ARRAY3 for testing
	
ADD R6, R6, -1; allocate spot on stack
	
STR R0, R6, 0; push argument ARRAY on stack

	
JSR ARRAYHOP

	
LDR R0, R6, 0; load return value off top of stack
	
ADD R6, R6, 3 ; restore stack to previous value

	
ST R0, ANSWER; store answer
	
HALT



ARRAY1 	.fill x5000

ARRAY2	.fill x5010

ARRAY3  .fill x5020

ANSWER 	.blkw 1

STACK 	.fill xF000



ARRAYHOP
	

ADD R6, R6, -1; MOVE UP STACK 4 SPOTS
	
ADD R6, R6, -1;
	
ADD R6, R6, -1

ADD R6, R6, -1	
STR R7,R6, 2; STORE RETURN ADDRESS
	
STR R5, R6, 1; STORE OLD FRAME POINTER
	
ADD R5, R6, 0;SET NEW FRAME POINTER
	
ADD R6, R6,-1;ALLOCATE SPACE FOR 1 LOCAL

LDR R0, R5, 4;LOAD array
AND R1, R1, 0;
LDR R1, R5, 5; LOAD IDX

ADD R0, R0, R1; ADDRESS ARRAY[IDX]
LDR R0, R0, 0; ARRAY[IDX]  NEED TO SEE IF THIS LINE GRABS FROM LIST CORRECTLY  R0= ARRAY[IDX]
STR R0, R5, 0; STORE N AS A LOCAL


LDR R0, R5, 0;	

;CONDITIONS
	
BRnp ELSE
	;IF N == 0
	
AND R2, R2, 0 ; R2 = 0
	
STR R2, R5, 3 ;STORE 0 AS RETURN VALUE
	
BR RETURN;GOTO RETURN PART



ELSE
	

LDR R0, R5, 4; LOAD ARRAY
AND R1, R1, 0;
LDR R1, R5, 0; LOAD N
AND R2, R2, 0;
LDR R2, R5, 5; LOAD IDX

ADD R2, R2, R1; IDX + N

	
ADD R6, R6, -1; ALLOCATE SPACE FOR IDX + N	
STR R2, R6,0; PUSH IDX + N ONTO STACK
	
ADD R6, R6, -1; ALLOCATE SPACE FOR ARRAY	
STR R0, R6,0; PUSH ARRAY ONTO STACK

JSR ARRAYHOP;QUESTION IF NEXT LINE RIGHT


	
LDR R0, R6, 0; READ RETURN VALUE OFF THE TOP OF STACK
	
ADD R6, R6, 3; POP ANSWER OFF OF STACK
	
AND R1, R1, 0; 

ADD R1, R1, 1;
	
ADD R0, R0, R1; RETURN 1 +ARRAYHOP(ARRAY, INX + N)	
STR R0, R5, 3; STORE RETURN VALUE
	



RETURN
	
ADD R6, R5, 3; STACKPOINTER ON RV
	
LDR R7, R5, 2; RESTORE R7 RETURN ADDRESS
	
LDR R5, R5, 1; RESTORE OFP
	
RET; RETURN
	

.end


; 4 hops

.orig x5000
	
.fill 2
	
.fill 1
	
.fill 3
	
.fill 0
	
.fill -1
	
.fill -1

.end


; 5 hops

.orig x5010
	
.fill 1
	
.fill 1
	
.fill 1
	
.fill 3

	.fill 0
	
.fill -12
	
.fill -2

.end


; 12 hops

.orig x5020
	
.fill 5
	
.fill 1
	
.fill 0

	.fill -3
	
.fill 10
	
.fill -1
	
.fill 5

	.fill 20
	
.fill 2
	
.fill 3
	
.fill 1
	
.fill -2
	
.fill 9
	
.fill 14
	
.fill 3

	.fill 20
	
.fill -2

	.fill -7
	
.fill 5
	
.fill 1
	
.fill -18

	.fill -2

.end
