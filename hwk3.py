#Kyle Young - ID#188
def same_first_digit(digit1, digit2, digit3):
    if str(digit1)[0] == str(digit2)[0] and str(digit2)[0] == str(digit3)[0] and str(digit1)[0] == str(digit3)[0]:
        return True
    else:
        return False

def get_piece_value(piece):
    chess = dict([
            ("pawn", 1),
            ("bishop", 3),
            ("knight", 3),
            ("rook", 5),
            ("queen", 9),
    ])
    if piece == "pawn" or piece == "bishop" or piece == "knight" or piece == "rook" or piece == "queen":
        return chess[piece] 
    else:
        return None

def which_season(month, day):
    if month == 1 :
        return "winter"
    elif month == 2 :
        return "winter"
    elif month == 3 and day < 20 :
        return "winter"
    elif month == 3 and day >= 20 :
        return "spring"
    elif month == 4 :
        return "spring"
    elif month == 5 :
        return "spring"
    elif month == 6 and day < 21 :
        return "spring"
    elif month == 6 and day >= 21 :
        return "summer"
    elif month == 7 :
        return "summer"
    elif month == 8 :
        return "summer"
    elif month == 9 and day < 22 :
        return "summer"
    elif month == 9 and day >= 22 :
        return "fall"
    elif month == 10 :
        return "fall"
    elif month == 11 :
        return "fall"
    elif month == 12 and day < 21 :
        return "fall"
    elif month == 12 and day >= 21 :
        return "winter"

def number_to_word(num):
    zero_to_nine = dict([
                    (0, "zero"),
                    (1, "one"),
                    (2, "two"),
                    (3, "three"),
                    (4, "four"),
                    (5, "five"),
                    (6, "six"),
                    (7, "seven"),
                    (8, "eight"),
                    (9, "nine")
    ])
    
    ten_to_nineteen = dict([
                        (10, "ten"),
                        (11, "eleven"),
                        (12, "twelve"),
                        (13, "thirteen"),
                        (14, "fourteen"),
                        (15, "fifteen"),
                        (16, "sixteen"),
                        (17, "seventeen"),
                        (18, "eighteen"),
                        (19, "nineteen")
    ])
    
    twenty_to_ninety = dict([
                        (20, "twenty"),
                        (30, "thirty"),
                        (40, "forty"),
                        (50, "fifty"),
                        (60, "sixty"),
                        (70, "seventy"),
                        (80, "eighty"),
                        (90, "ninety"),
    ])
    
    if (num == 0):
        return "zero"
    elif (len(str(num)) == 1):
        return zero_to_nine[num]
    elif (len(str(num)) == 2):
        not_twenty = (num - 20)
        if(not_twenty < 0):
             return ten_to_nineteen[num]
        elif(not_twenty >= 0 and (not_twenty % 10 == 0)):
            return twenty_to_ninety[num]
        else:
            first_number = num % 10
            second_number = num - first_number
            return (twenty_to_ninety[second_number]) + " " + (zero_to_nine[first_number])