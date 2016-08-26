;;===============================
;;Name: Stephanie Remy
;;===============================

.orig x3000

AND R1, R1, 0  ;;registars equal to zero
AND R2, R2, 0
AND R3, R3, 0
LD R1, A       ;; loaded labels into registers
LD R2, B
NOT R1, R1     ;; not a
NOT R2, R2     ;; not b
AND R3, R1, R2 ;; a and b
NOT R3, R3     ;; not answer
ST R3, ANSWER  ;; store answer in answer
HALT
	
A       .fill 6
B       .fill 13
ANSWER  .fill 0		;  A | B 
.end
