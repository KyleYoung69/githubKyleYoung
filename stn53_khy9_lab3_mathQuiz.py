from random import randint
print('What difficulty would you like?')
difficulty = input('BEGINNER, INTERMEDIATE, ADVANCED\n')
question_total = int(input('How many questions would you like?'))
correct = 0
questions_asked = 0
if difficulty == 'BEGINNER':
    while questions_asked < question_total:
        operator = randint(1, 2)
        if operator == 1:
            n1 = randint(1, 10)
            n2 = randint(1, 10)
            sum = n1 + n2

            ans = input(f"What's {n1} plus {n2}? ")
            if int(ans) == sum:
                print("That's right -- well done.\n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {sum}.\n")
                questions_asked += 1
        else:
            n1 = randint(1, 10)
            n2 = randint(1, 10)
            diff = n1 - n2

            ans = input(f"What's {n1} minus {n2}?\n")
            if int(ans) == diff:
                print("That's right -- well done. \n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {diff}.\n")
                questions_asked += 1
elif difficulty == 'INTERMEDIATE':
    while questions_asked < question_total:
        operator = randint(1, 4)
        if operator == 1:
            n1 = randint(1, 25)
            n2 = randint(1, 25)
            sum = n1 + n2

            ans = input(f"What's {n1} plus {n2}?\n")
            if int(ans) == sum:
                print("That's right -- well done.\n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {sum}.\n")
                questions_asked += 1
        elif operator == 2:
            n1 = randint(1, 25)
            n2 = randint(1, 25)
            diff = n1 - n2

            ans = input(f"What's {n1} minus {n2}?\n")
            if int(ans) == diff:
                print("That's right -- well done. \n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {diff}.\n")
                questions_asked += 1
        elif operator == 3:
            n1 = randint(1, 25)
            n2 = randint(1, 25)
            prod = n1 * n2

            ans = input(f"What's {n1} times {n2}?\n")
            if ans == '':
                print(f"No, I'm afraid the answer is {prod}.\n")
                questions_asked += 1
            if int(ans) == prod:
                print("That's right -- well done. \n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {prod}.\n")
                questions_asked += 1
        else:
            n1 = randint(1, 25)
            n2 = randint(1, 25)
            quot = round((n1 / n2), 2)
            ans = float(input(f"What's {n1} divided {n2}?\n"))
            round_ans = round(ans, 2)
            if (round_ans) == quot:
                print("That's right -- well done. \n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {quot}.\n")
                questions_asked += 1

elif difficulty == 'ADVANCED':
    while questions_asked < question_total:
        operator = randint(1, 5)
        if operator == 1:
            n1 = randint(1, 25)
            n2 = randint(1, 25)
            n3 = randint(1, 25)
            sum_diff = n1 + n2 - n3

            ans = input(f"What's {n1} plus {n2} - {n3}?\n")
            if int(ans) == sum_diff:
                print("That's right -- well done.\n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {sum_diff}.\n")
                questions_asked += 1
        elif operator == 2:
            n1 = randint(1, 25)
            n2 = randint(1, 25)
            n3 = randint(1, 25)
            prod_diff = n1 * n2 - n3

            ans = input(f"What's {n1} times {n2} minus {n3}?\n")
            if ans == '':
                print(f"No, I'm afraid the answer is {prod_diff}.\n")
                questions_asked += 1
            elif int(ans) == prod_diff:
                print("That's right -- well done. \n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {prod_diff}.\n")
                questions_asked += 1
        elif operator == 3:
            n1 = randint(1, 25)
            n2 = randint(1, 25)
            n3 = randint(1, 25)
            sum_prod = n1 + n2 * n3

            ans = input(f"What's {n1} plus {n2} times {n3}?\n")
            if int(ans) == sum_prod:
                print("That's right -- well done. \n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {sum_prod}.\n")
                questions_asked += 1
        elif operator == 4:
            n1 = randint(1, 25)
            n2 = randint(1, 25)
            n3 = randint(1, 25)
            prod_prod = n1 * n2 * n3

            ans = input(f"What's {n1} times {n2} times {n3}?\n")
            if ans == prod_prod:
                print("That's right -- well done. \n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {prod_prod}.\n")
                questions_asked += 1
        else:
            n1 = randint(1, 25)
            n2 = randint(1, 25)
            n3 = randint(1, 25)
            quot = round((n1 / n2), 2)
            sum_quot = n3 + quot

            ans = float(input(f"What's {n1} divided {n2} plus {n3}?\n"))
            round_ans = round(ans, 2)
            if (round_ans) == sum_quot:
                print("That's right -- well done. \n")
                correct += 1
                questions_asked += 1
            else:
                print(f"No, I'm afraid the answer is {sum_quot}.\n")
                questions_asked += 1

print(f"\nI asked you {question_total} questions. You got {correct} of them right.")
upper = question_total * (2/3)
lower = question_total * (1/3)
if correct <= question_total and correct >= upper:
    print(f"\nWell Done!")
elif correct < upper and correct >= lower:
    print(f"\nYou need more practice")
else:
    print(f"\nPlease ask your math teacher for help")
