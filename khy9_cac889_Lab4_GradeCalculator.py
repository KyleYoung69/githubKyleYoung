# Lab4_grade_calculator
# Charlie_cuellar nad Kyle Young
# we went back and put this in


def average(score_list, max_list):
    print(f"list of scores: {scores}")
    scores_sum = sum_list(score_list)
    print(f"sum of all scores in list: {scores_sum}")
    maximums_sum = sum_list(max_list)
    print(f"sum of all maximums in list: {maximums_sum}")
    just_average = int((scores_sum / maximums_sum) * 100)
    if just_average >= 90:
        letter_grade = "(A)"
    elif just_average < 90 and just_average >= 80:
        letter_grade = "(B)"
    elif just_average < 80 and just_average >= 70:
        letter_grade = "(C)"
    elif just_average < 70 and just_average >= 60:
        letter_grade = "(D)"
    else:
        letter_grade = "(F)"
    print(f"Grade: {just_average} {letter_grade}")


def sum_list(list_to_sum):
    return_value = sum(list_to_sum)
    return return_value


def main():
    # this is the homework grade
    scores = [39, 40, 29, 40, 0, 5]
    maximums = [40, 40, 40, 40, 40, 5]
    print(f"list of scores: {scores}")
    scores_sum = sum_list(scores)
    print(f"sum of all scores in list: {scores_sum}")
    maximums_sum = sum_list(maximums)
    print(f"sum of all maximums in list: {maximums_sum}")
    just_average = int((scores_sum / maximums_sum) * 100)
    if just_average >= 90:
        letter_grade = "(A)"
    elif just_average < 90 and just_average >= 80:
        letter_grade = "(B)"
    elif just_average < 80 and just_average >= 70:
        letter_grade = "(C)"
    elif just_average < 70 and just_average >= 60:
        letter_grade = "(D)"
    else:
        letter_grade = "(F)"
    print(f"Homework grade: {just_average} {letter_grade}")

# this is the homework, quiz and test grade.
# this portion is homework
    hwk_score = [39, 40, 29, 40, 0, 5]
    hwk_max = [40, 40, 40, 40, 40, 5]
    quiz_score = [10, 10, 9, 2, 10, 10, 10]
    quiz_max = [10, 10, 10, 10, 10, 10, 10]
    test_score = [293, 284, 300]
    test_max = [300, 300, 300]
    print(f"list of homework scores: {hwk_score}")
    hwk_score_sum = sum_list(hwk_score)
    print(f"sum of all homework scores in list: {hwk_score_sum}")
    hwk_max_sum = sum_list(hwk_max)
    print(f"sum of all maximums in list: {hwk_max_sum}")
    hwk_ave = int((hwk_score_sum / hwk_max_sum) * 100)
    if hwk_ave >= 90:
        hwk_letter_grade = "(A)"
    elif hwk_ave < 90 and hwk_ave >= 80:
        hwk_letter_grade = "(B)"
    elif hwk_ave < 80 and hwk_ave >= 70:
        hwk_letter_grade = "(C)"
    elif hwk_ave < 70 and hwk_ave >= 60:
        hwk_letter_grade = "(D)"
    else:
        hwk_letter_grade = "(F)"
# quiz
    print(f"list of quiz scores: {quiz_score}")
    quiz_score_sum = sum_list(quiz_score)
    print(f"sum of all quiz scores in list: {quiz_score_sum}")
    quiz_max_sum = sum_list(quiz_max)
    print(f"sum of all maximums in list: {quiz_max_sum}")
    quiz_ave = int((quiz_score_sum / quiz_max_sum) * 100)
    if quiz_ave >= 90:
        quiz_letter_grade = "(A)"
    elif quiz_ave < 90 and quiz_ave >= 80:
        quiz_letter_grade = "(B)"
    elif quiz_ave < 80 and quiz_ave >= 70:
        quiz_letter_grade = "(C)"
    elif quiz_ave < 70 and quiz_ave >= 60:
        quiz_letter_grade = "(D)"
    else:
        quiz_letter_grade = "(F)"
# test
    print(f"list of test scores: {test_score}")
    test_score_sum = sum_list(test_score)
    print(f"sum of all test scores in list: {test_score_sum}")
    test_max_sum = sum_list(test_max)
    print(f"sum of all maximums in list: {test_max_sum}")
    test_ave = int((test_score_sum / test_max_sum) * 100)
    if test_ave >= 90:
        test_letter_grade = "(A)"
    elif test_ave < 90 and test_ave >= 80:
        test_letter_grade = "(B)"
    elif test_ave < 80 and test_ave >= 70:
        test_letter_grade = "(C)"
    elif test_ave < 70 and test_ave >= 60:
        test_letter_grade = "(D)"
    else:
        test_letter_grade = "(F)"
    print(f"Homework grade: {hwk_ave} {hwk_letter_grade}")
    print(f"Quiz grade: {quiz_ave} {quiz_letter_grade}")
    print(f"Test grade: {test_ave} {test_letter_grade}")
# more weight
    final_score = int((hwk_ave * .19) + (quiz_ave * .26) + (test_ave * .55))
    if final_score >= 90:
        final_score_grade = "(A)"
    elif final_score < 90 and test_ave >= 80:
        final_score_grade = "(B)"
    elif final_score < 80 and test_ave >= 70:
        final_score_grade = "(C)"
    elif final_score < 70 and test_ave >= 60:
        final_score_grade = "(D)"
    else:
        final_score_grade = "(F)"
    print(f"Final Score {final_score} {final_score_grade}")


if __name__ == "__main__":
    main()
