#Kyle Young ID - 188

def number_to_word(num):
    ones = {
            1 : 'one',
            2 : 'two', 
            3 : 'three',
            4 : 'four',
            5 : 'five',
            6 : 'six',
            7 : 'seven',
            8 : 'eight',
            9 : 'nine'}

    teens = {
            10 : 'ten',
            11 : 'eleven',
            12 : 'twelve',
            13 : 'thirteen',
            14 : 'fourteen',
            15 : 'fifteen',
            16 : 'sixteen',
            17 : 'seventeen',
            18 : 'eighteen',
            19 : 'nineteen',}

    twentyups = {
                20 : 'twenty',
                30 : 'thirty',
                40 : 'forty',
                50 : 'fifty',
                60 : 'sixty',
                70 : 'seventy',
                80 : 'eighty',
                90 : 'ninety',}
            
    if num == 0:
        return 'zero'
    elif len(str(num)) == 1:
        return ones[num]
    elif len(str(num)) == 2:
        finder = (num - 20)
        if finder < 0:
            return teens[num]
        elif finder >= 0 and finder % 10 == 0:
            return twentyups[num]
        else:
            first_num = num % 10
            second_num = num - first_num
            return twentyups[second_num] + ' ' + ones[first_num]


def is_palindrome(word):
    palinword = word[::-1]
    if palinword.replace("'","").replace(',','').replace(" ","").upper() == word.replace("'","").replace(',','').replace(" ","").upper():
        return True
    else:
        return False




def format_date(date):
    d = {
        "01" : "January",
        "02" : "February",
        "03" : "March",
        "04" : "April",
        "05" : "May",
        "06" : "June",
        "07" : "July",
        "08" : "August",
        "09" : "September",
        "10" : "October",
        "11" : "November",
        "12" : "December",}
        
    year = date[:4]
    month = d[date[4:6]]
    numbah = date[6:]
    if date[6] == "0":
        day = numbah.replace("0","")
        if day == "1" or day == "21":
            return month + " " + day + "st, " + year
        elif day == "2" or day == "22":
            return month + " " + day + "nd, " + year
        elif day == "3" or day == "23":
            return month + " " + day + "rd, " + year
        else:
            return month + " " + day + "th, " + year
    else:
        day = numbah
        if day == "1" or day == "21":
            return month + " " + day + "st, " + year
        elif day == "2" or day == "22":
            return month + " " + day + "nd, " + year
        elif day == "3" or day == "23":
            return month + " " + day + "rd, " + year
        else:
            return month + " " + day + "th, " + year

def romanize(num):
    ones = {
            1 : 'I',
            2 : 'II',
            3 : 'III',
            4 : 'IV',
            5 : 'V',
            6 : 'VI',
            7 : 'VII',
            8 : 'VIII',
            9 : 'IX'
    }
    tens = {
            10 : 'X',
            20 : 'XX',
            30 : 'XXX',
            40 : 'XL',
            50 : 'L',
            60 : 'LX',
            70 : 'LXX',
            80 : 'LXXX',
            90 : 'XC'}
    if num == 0:
        return ""
    elif len(str(num)) == 1:
        return ones[num]
    elif len(str(num)) == 2:
        if num % 10 == 0:
            return tens[num]
        else:
            return tens[num-(num % 10)] + ones[num % 10]


# Function 4: Extra Credit! Standardize phone numbers
#
# Uncomment the lines below to enter into the mystery
# def standardize_phone_number(phone_number):
#     return False
