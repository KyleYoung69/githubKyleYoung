# Kyle Young
# ID 188
import sys

def nospace(yearline):
    index = 1
    while index < len(yearline):
        yearline[index] = yearline[index].replace(' ','').replace('\t','')
        index = index + 1
        
        
        
    
def main():
    input = open(sys.argv[1], "r")
    outputfile = open("summary.txt", "w")
    setyear = (sys.argv[2])
    list_of_things = []
    for i in input:
        list_of_things.append(i)
    
    index = 0
    print(list_of_things)
    for line in list_of_things:
        yearline = line.split(",") 
        while index < 1:
            stateindex = yearline.index('State')
            popindex = yearline.index('Projected Populations\n')
            yearindex = yearline.index('Year')
            index = index + 1
        list_of_things.sort()
        nospace(yearline)
        state = (yearline[stateindex])
        year = yearline[yearindex] 
        population = yearline[popindex]
        if year == setyear:
            outputfile.write(f"{state}: {population}")
    input.close()
    outputfile.close()
if __name__ == '__main__':
    main()
