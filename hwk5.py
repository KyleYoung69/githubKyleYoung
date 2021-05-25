# Kyle Young
# ID - 188
def is_vowel(letter):
        return letter.lower() in ['a', 'e', 'i', 'o', 'u', 'y']

def count_vowels(word):
    number_of_vowels = 0
    #finding how long each word is
    for letter in range(len(word)):
        # Checking if the vowel appears or not
        if is_vowel(word[letter]):
            number_of_vowels += 1
            
    return number_of_vowels

def str_to_ascii(string):
    result = []
    for letter in string:
        integer = ord(letter)
        result.append(integer)
    return result


def remove_vowels(word):
    no_vowel_word = ''
    for letter in word:
        if letter == 'a' or letter == 'e' or letter == 'i' or letter == 'o' or letter == 'u' or letter == 'y':
            no_vowel_word = no_vowel_word + ''
        elif letter == 'A' or letter == 'E' or letter == 'I' or letter == 'O' or letter == 'U' or letter == 'Y':
            no_vowel_word = no_vowel_word + ''
        else:
            no_vowel_word = no_vowel_word + letter
            
    return no_vowel_word.lower()

def every_other_character(string):
    result = ''
    index = 0
    while index < len(string):
        result = result + string[index] 
        index = index + 2
    return result

def max(numbers):
    maximum = numbers[0]
    for num in numbers:
        if num > maximum:
            maximum = num
    return maximum

def is_palindrome(sentence):
    palindrome = ''
    for word in sentence:
        palindrome = word[-1] + palindrome
    if palindrome.replace(" ","").replace("'","").replace(",","").lower() == sentence.replace(" ","").replace("'","").replace(",","").lower():
        return True
    else:
        return False