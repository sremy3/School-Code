;;===============================
;;Name: Stephanie Remy
;;===============================

.orig x3000

	AND R0, R0, 0; COUNT = 0
	AND R1, R1, 0
	AND R2, R2, 0
	AND R3, R3, 0
	LD R1, LENGTH; GET LENGTH
	BRnz SKIPLOOP; If length <= 0, skip loop
	LD R2, ARRAY; CURRENT ITEM IN ARRAY
	LOOP
	LDR R3, R2, 0; n = ARRAY item
	BRzp NOTNEGATIVE; IF ITEM < 0
	ADD R0, R0, 1; COUNT += n
	NOTNEGATIVE
	ADD R2, R2, 1; increment array pointer
	ADD R1, R1, -1; LENGTH--
	BRp LOOP
	SKIPLOOP
	ST R0, ANSWER; store answer in ANSWER
	HALT
	
ARRAY   .fill x6000
LENGTH  .fill 10
ANSWER	.fill 0		; The number of negative values.
.end

.orig x6000
.fill -20
.fill -14
.fill -7
.fill 0
.fill -3
.fill -255
.fill -9
.fill -9
.fill 2
.fill 25
.end
