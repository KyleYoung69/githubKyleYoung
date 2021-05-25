# CS LAB 09 Draw Stars
# Kyle. Y and Zach. B
# December 4th 2019
# Lab Section 006
import sys
import turtle
t = turtle.Turtle()
# turtle setup
turtle.setup(500, 500, 0, 0)
turtle.speed(0)
turtle.tracer(0)
turtle.bgcolor('black')

# gets the x cord
def get_x_cord(data):
    list_o_data = data.split(' ')
    return float(list_o_data[0])
    
# gets the y cord
def get_y_cord(data):
    list_o_data = data.split(' ')
    return float(list_o_data[1])
    
# we didnt need this in the end, but it should get the z cord
def get_z_cord(data):
    list_o_data = data.split(' ')
    return float(list_o_data[2])

# we didnt need this in the end, but it should get the hd_number
def get_hd_num(data):
    list_o_data = data.split(' ')
    return float(list_o_data[3])

# gets the density
def get_brightness(data):
    list_o_data = data.split(' ')
    return min(round(10/(float(list_o_data[4]) + 2)),8)

# the whole shabang
def main():
    data = open(sys.argv[1], 'r')    
    for star in data:
        x_cord = get_x_cord(star) * 250
        y_cord = get_y_cord(star) * 250
        turtle.penup()
        turtle.goto(x_cord, y_cord)
        turtle.pendown()
        turtle.dot(get_brightness(star),'white')
    turtle.exitonclick()
if __name__ == '__main__':
    main()