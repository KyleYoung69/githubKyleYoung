# Lab 6: Banners
# Ariel Robinson & Kyle Young
# 23 October 2019
# CS126L - 06
# This is our dictionary.
# We put a space after each line so that they weren't stuck together
d = {
    "a": [" AAA  ",
          "A   A ",
          "AAAAA ",
          "A   A ",
          "A   A "],
    "b": ["BBBBB ",
          "B   B ",
          "BBBB  ",
          "B   B ",
          "BBBBB "],
    "c": [" CCCC ",
          "C     ",
          "C     ",
          "C     ",
          " CCCC "],
    "d": ["DDD   ",
          "D  D  ",
          "D   D ",
          "D  D  ",
          "DDD   "],
    "e": ["EEEEE ",
          "E     ",
          "EEEEE ",
          "E     ",
          "EEEEE "],
    "f": ["FFFFF ",
          "F     ",
          "FFFF  ",
          "F     ",
          "F     "],
    "g": [" GGGG ",
          "G     ",
          "G  GG ",
          "G   G ",
          " GGG  "],
    "h": ["H   H ",
          "H   H ",
          "HHHHH ",
          "H   H ",
          "H   H "],
    "i": ["IIIII ",
          "  I   ",
          "  I   ",
          "  I   ",
          "IIIII "],
    "j": ["    J ",
          "    J ",
          "    J ",
          "J   J ",
          " JJJ  "],
    "k": ["K   K ",
          "K  K  ",
          "KK    ",
          "K  K  ",
          "K   K "],
    "l": ["L     ",
          "L     ",
          "L     ",
          "L     ",
          "LLLLL "],
    "m": ["M   M ",
          "MM MM ",
          "M M M ",
          "M M M ",
          "M M M "],
    "n": ["N   N ",
          "NN  N ",
          "N N N ",
          "N  NN ",
          "N   N "],
    "o": ["OOOOO ",
          "O   O ",
          "O   O ",
          "O   O ",
          "OOOOO "],
    "p": ["PPPP  ",
          "P   P ",
          "PPPP  ",
          "P     ",
          "P     "],
    "q": [" QQQ  ",
          "Q   Q ",
          "Q   Q ",
          " QQQ  ",
          "    Q "],
    "r": ["RRRR  ",
          "R   R ",
          "RRRR  ",
          "R  R  ",
          "R   R "],
    "s": [" SSSS ",
          "S     ",
          " SSS  ",
          "    S ",
          "SSSS  "],
    "t": ["TTTTT ",
          "  T   ",
          "  T   ",
          "  T   ",
          "  T   "],
    "u": ["U   U ",
          "U   U ",
          "U   U ",
          "U   U ",
          " UUU  "],
    "v": ["V   V ",
          "V   V ",
          "V   V ",
          " V V  ",
          "  V   "],
    "w": ["W W W ",
          "W W W ",
          "W W W ",
          "W W W ",
          " W W  "],
    "x": ["X   X ",
          " X X  ",
          "  X   ",
          " X X  ",
          "X   X "],
    "y": ["Y   Y ",
          " Y Y  ",
          "  Y   ",
          "  Y   ",
          "  Y   "],
    "z": ["ZZZZZ ",
          "   Z  ",
          "  Z   ",
          " Z    ",
          "ZZZZZ "],
    " ": ["     ",
          "     ",
          "     ",
          "     ",
          "     "]

}

# This one prints vertically
# it uses the outer loop to get the the layers of letter
# it uses the inner loop to get the range of the key of the letter
# the range is 5 because the letter hight is 5


def print_vertical_banner(string):
    for letter in string:
        for key in range(5):
            print(d[letter][key])


# we used the end='' to end the line with nothing
def print_horizontal_banner(string):
    for key in range(5):
        for letter in string:
            print(d[letter][key], end='',)
        print()


# this is a function to print a banner when taken in a direction
def print_banner(string, direction):
    if direction == 'vertical':
        print_vertical_banner(string)
    elif direction == 'horizontal':
        print_horizontal_banner(string)
    else:
        print('thats not a direction dummy')
