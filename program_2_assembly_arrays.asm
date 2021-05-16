#Author: Kyle Young
#Date: 4/2/2020
#Program: Program 2
#Class: CS200-002

	 .data
numArray: 	.word	5, 3, 12, 10, 4
size:		.word 5 
space:		.asciiz " "
endLine:	.asciiz "\n"
			
 	
	.text

	.globl main
main:
	li 	$s0, 0		
	lw	$s1, size
	li 	$s3, 0		

loop:
	beq	$s3, $s1, loop_end
	lw	$t0, numArray($s0)
	addi	$s0, 4
	addi	$s3, 1
	
	li 	$v0, 1
	move 	$a0, $t0
	syscall

	li	$v0, 4
	la	$a0, space
	syscall
 							
	j	loop	
loop_end:
end_line:
	li	$v0, 4
	la	$a0, endLine
Bubble:
	li	$t7, 24
	li	$t1, 8
outer:
	lw	$t0, numArray ($0)
	sub	$t4, $t7, $t1
	li	$t2, 0
inner:
	addi	$t3, $t2, 4
if:
	lw	$t6, numArray($t3) 
	blt	$t0, $t6, else
then:
	sw	$t6, numArray($t2) 
	b	endif
else:
	sw	$t0, numArray($t2)
	lw	$t0, numArray($t3)
endif:
	addi	$t2, $t2, 4
	blt	$t2, $t4, inner
inner_end:
	sw	$t0, numArray($t4)
	addi	$t1, $t1, 4
	blt	$t1, $t7, outer
outer_end:
	j	$ra
loop2:
	beq	$s3, $s1, loop2_end
	lw	$t0, numArray($s0)
	addi	$s0, 4
	addi	$s3, 1
	
	li 	$v0, 1
	move 	$a0, $t0
	syscall

	li	$v0, 4
	la	$a0, space
	syscall
 							
	j	loop	
loop_end2:
	li	$v0, 10
	syscall


	