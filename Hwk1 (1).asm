#Author: 
#Date:
#Program: Add two numbers
#Class: CS200-xxx
	 .data
num1: 	.word 0
num2: 	.word 0
num3:	.word 0 
result: 	.word 0
prompt: 	.asciiz "Enter Number:"
prompt2:	.asciiz "Enter Number:"
prompt3:	.asciiz "Enter Number:"
 	
	.text

	.globl main
main:
	lw 	 $t0, num1
	lw 	 $t1, num2

	li 	 $v0, 5
	la	 $a0 prompt
	syscall
	 
	li	$v0, 5
	syscall
	move 	$t0, $v0
	sw	$t0, num1

	#add 	 $s0, $t0, $t1	#adds two integers

	#sw 	 $s0, result	#stores s0 out into result
	#lw 	 $t4, result

	#li 	 $v0, 4
	#la 	 $a0, msg
	#syscall

	#li 	 $v0, 1
	#move	 $a0, $t4
	#syscall


	li 	 $v0, 10
	syscall