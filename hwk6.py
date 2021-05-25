# Kyle Young
# ID - 188
# October 29th, 2019

def checksum(string):
    sum = 0
    for letter in string:
       sum = ord(letter) + sum
    return sum

def character_frequency(word, character):
    frequency = 0
    for letter in word:
        if letter == character:
           frequency = frequency + 1
    return (frequency / len(word)) * 100

def first_factor(number):
    for x in range(2,number + 1):
        if (number % x) == 0:
            return x

def is_prime(number):
    if first_factor(number) == number:
        return True
    else:
        return False

def all_parens_matched(string):
    leftlist = []
    rightlist = []
    index = 0
    for character in string:
        if character == "(":
            leftlist.append(index)
        elif character ==")":
            rightlist.append(index)
        index = index + 1
    if len(leftlist) != len(rightlist):
        return False
    else:
        for x in range(len(leftlist)):
            if leftlist[x] > rightlist[x]:
                return False
            else:
                return True
            