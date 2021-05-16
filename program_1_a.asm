#Author: Kyle Young
#Date: March 12th 2020
#Program: Add two numbers and subtract the third
#Class: CS200-001
	 .data
num1: 	.word 0
num2: 	.word 0
num3:		.word 0 
addresult:	.word 0
result:	.word 0

prompt: 	.asciiz "Enter First Number: "
prompt2:	.asciiz "Enter Second Number: "
prompt3:	.asciiz "Enter Third Number: "
resultmsg:	.asciiz "Result is: "
 	
	.text

	.globl main
main:
	lw 	 $t0, num1		#loads num1
	li 	 $v0, 4		#prints a string
	la	 $a0, prompt	#tells it to print prompt
	syscall			#runs it
	
	li	$v0, 5		#reads an intager (user input)
	syscall			#runs it
	move 	$t0, $v0		#moves it to a part of memory (t0)
	sw	$t0, num1		#stores it in part of memory
	

	lw 	 $t1, num2		#loads num2
	li 	 $v0, 4		#prints a string
	la	 $a0, prompt2	#tells it to print prompt2
	syscall			#runs it
	
	li	$v0, 5		#reads an intager (user input)
	syscall			#runs it
	move 	$t1, $v0		#moves it to a part of memory (t1)
	sw	$t1, num1		#stores it in part of memory

	lw 	 $t2, num3		#loads num3
	li 	 $v0, 4		#prints a string
	la	 $a0, prompt3	#tells it to print prompt3
	syscall			#runs it
	
	li	$v0, 5		#reads an intager (user input)
	syscall			#runs it
	move 	$t2, $v0		#moves it to a part of memory (t2)
	sw	$t2, num3		#stores it in part of memory


	

	sub	 $s0, $t0, $t1	#subtracts two integers

	sw 	 $s0, addresult	#stores s0 out into addresult
	lw 	 $t3, addresult	#loads add result into memory (t3)

	add	 $s1, $t3, $t2  #adds the subtracted result by the
					#last number (t3 + t2)
	sw	 $s1, result	#stores s1 out int result
	lw 	 $t4, result 	#loads result into memory (t4)

	li 	 $v0, 4		#prints a string
	la 	 $a0, resultmsg	#tells it to print resultmsg
	syscall			#runs it

	li 	 $v0, 1		#prints an integer
	move	 $a0, $t4		#tells it to print whats at t4
	syscall			#runs it


	li 	 $v0, 10		#tells it to end the program
	syscall			#runs it