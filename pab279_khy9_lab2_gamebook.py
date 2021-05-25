# Parker Brown and Kyle Young (pab279 and khy9)
# September 18, 2019
# Gamebook/Lab2


print("You are running down a dark corridor, coming to a set of three doors.")
print("The first door has a key hanging from it and a dusty handprint.")
print("It is damply illuminated by the soft, flickering light.")
print("Door 2 is a cold green color and no doorknob.")
print("When you enter, you can never come back through it.")
print("Door 3 has a dagger in it and a blood message saying, 'DO NOT ENTER!")
# We need to choose one of three doors - this is our three input DP
choice1 = input("Do you open DOOR1, DOOR2 or DOOR3?")
# Option 1 will execute if door 1 is chosen
if choice1 == "DOOR1":
    print("You take the key from the string dangling.")
    print("You do this only to realize that the door is already unlocked.")
    print("As you enter, you see a childs abandonded play room.")
    print("There is a small box and a coffin laying in the corner.")
    print("You must now choose; whih one do you unlock with your key?")
# This is a second path, allowing a choice of "coffin" and "box"
    box_or_coffin = input("Do you open the BOX or the COFFIN?")
# This is choice 1, specifying if "coffin" is chosen
    if box_or_coffin == "COFFIN":
        print("The coffin entices you, so you choose to go unlock it.")
        print("The key doesn't seem to work...")
        print("Luckily for you, it also happens to be unlocked.")
        print("Unluckily for you, confetti shoots out, ruining your shoes...")
        print("You then die from the shock that ensues.")
# The next line covers the other option, if "box" is chosen
    else:
        print("The box looks enticing...")
        print("You stumble to the box, and on your way you trip over a doll.")
        print("You fling the key into the lock of the box.")
        print("The box then opens, and a LARGE Nakai emerges from the box.")
        print("He then eats your soul. You are now dead.")
# The next line is if "door2" is chosen from the original option
elif choice1 == "DOOR2":
    print("You open the cold green door with no doorknob and you enter.")
    print("The door slams behind you and you hear the deadbolt lock.")
    Print("You are then faced with two slides.")
    print("The one on your left is a curly plastic slide.")
    print("The one on the right is a slide made of hard metal.")
    print("You must make another dicision.")
# If you choose left, it brings you to another set of decisions
# This is our way to get the 3 series of DP's
    right_or_left = input("Do you take LEFT or RIGHT slide?")
    if right_or_left == "LEFT":
        print("You take the slide and land in the ballpit of Chuck-E-Cheese.")
        print("You look around and find two areas.")
        print("One filled with delicious pizza.")
        print("The other is a fun room with THE Charles Entertainment Cheese.")
        print("The decision is yours.")
        pizza_or_charles = input("Do you go to CHARLES or get PIZZA?")
# This next line executes if the choice "pizza" is chosen
        if pizza_or_charles == "PIZZA":
            print("You take a bite of the pizza, realizing it has pineapple.")
            print("You die.")
# If "CHARLES" is chosen then it prints the following lines
        else:
            print("You go up to Chuck and ask him to sing a song for you.")
            print("Little did you know...")
            print("That was the last song you would ever request.")
            print("He absolutely obliterates you.")
            print("You are dead.")
# If you choose the right hand slide then the story takes a different turn
    else:
        print("You take the slide to your right.")
        print("You endlessly slide down the slide.")
        print("Your mind decays.")
# If you choose door3 from the original option, the next lines will happen
else:
    print("As you enter door 3, you hear screaming and shouting behind you.")
    print("You look behind you and see a vague amount of people chasing you.")
    print("How many do you think there are?")
    num_of_people = int(input("Name a number for how many people are there."))
# This one will ask for a numeric answer - this is our numeric answer DP
    if num_of_people < 20:
        print("You see a bit less than 20 people behind you.")
        print("It is not long before you realize that Nakai")
        print("is leading a mob of angry gnomes that you thought were people.")
        print("They proceeed to put you in the gnome box.")
        print("Gnomebody gnomes what will happen to you.")
# If the number chose is greater than 20 the story ends
    else:
        print("You see a bunch of partiers behind you all screaming")
        print("what you now can make out as happy birthday.")
        print("One hands you a hat and another hands you a")
        print("four loco and calls you a wizard.")
        print("You then wake up from your dream.")
        print("Good ending!")
