# Kyle Young and Samuel Northam

def get_category(word):
    first = word.split(' ')
    return first[0]

def get_percent(word):
    word = word.replace('%',"")
    first = word.split(' ')
    return first[1]

def get_scores(word):
    first = word.split(' ')
    return first[2].split(',')

def get_average(first):
    total_earned = 0
    total_possible = 0

    for item in first:
        temp = item.split("/")
        total_earned += int(temp[0])
        total_possible += int(temp[1])

    return (round((total_earned / total_possible), 2) * 100)

def get_grade(score):
    if score >= 90:
        return "A"
    elif score >= 80:
        return "B"
    elif score >= 70:
        return "C"
    elif score >= 60:
        return "D"
    else:
        return "F"

def print_html(category, average, grade):
    html_string = print_scores()

def main():
    input = open("grades.txt","r")
    output_file = open("output_grades.html", "w")
    first = []
    for i in input:
        first.append(i)

    for item in first:
        score_first = get_scores(item)
        average = int(get_average(score_first))
        grade = get_grade(average)
        category = get_category(item)
        weight = int(get_percent(item))
        contribution = (weight / 10000) * average

        output_file.write(f"""
<h1>{category} Statistics</h1><ul><li><b>Average:</b> {average}<li><b>Letter Grade:</b> {grade}<li><b>Overall Grade Contribution:</b> {contribution}</ul>
        """)

if __name__ == '__main__':
    main()