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
	
	li 	 $v0, 4		#prints a string
	la	 $a0, prompt	#tells it to print prompt
	syscall			#runs it
	
	li	$v0, 5		#reads an intager (user input)
	syscall			#runs it
	move 	$t0, $v0		#moves it to a part of memory (t0)
	

	
	li 	 $v0, 4		#prints a string
	la	 $a0, prompt2	#tells it to print prompt2
	syscall			#runs it
	
	li	$v0, 5		#reads an intager (user input)
	syscall			#runs it
	move 	$t1, $v0		#moves it to a part of memory (t1)
	

	
	li 	 $v0, 4		#prints a string
	la	 $a0, prompt3	#tells it to print prompt3
	syscall			#runs it
	
	li	$v0, 5		#reads an intager (user input)
	syscall			#runs it
	move 	$t2, $v0		#moves it to a part of memory (t2)
	


	

	sub	 $t4, $t0, $t1	#subtracts two integers

	add	 $t5, $t4, $t2  #adds the subtracted result by the
					#last number (t3 + t2)
	
	li 	 $v0, 4		#prints a string
	la 	 $a0, resultmsg	#tells it to print resultmsg
	syscall			#runs it

	li 	 $v0, 1		#prints an integer
	move	 $a0, $t5		#tells it to print whats at t4
	syscall			#runs it


	li 	 $v0, 10		#tells it to end the program
	syscall			#runs it